package model;

import java.util.ArrayList;
import model.dao.AlunoDAO;

public class Aluno {

    private int id;
    private String nome;
    private int idade;
    private String curso;
    private int fase;

    public Aluno() {
    }

    public Aluno(int id, String nome, int idade, String curso, int fase) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.fase = fase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return super.toString() + "curso=" + curso
                + ", fase=" + fase;
    }

    /* ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO SIMULANDO
A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS. */
// Retorna a Lista de Alunos(objetos)
    public ArrayList<Aluno> getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }
// Cadastra novo aluno

    public boolean insertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        getMinhaLista().add(objeto);
        return true;
    }
// Deleta um aluno específico pelo seu campo ID

    public boolean deleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        getMinhaLista().remove(indice);
        return true;
    }
// Edita um aluno específico pelo seu campo ID

    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        int indice = this.procuraIndice(id);
        getMinhaLista().set(indice, objeto);
        return true;
    }
// procura o INDICE de objeto da minhaLista que
// contem o ID enviado.

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < getMinhaLista().size(); i++) {
            if (getMinhaLista().get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
// carrega dados de um aluno específico pelo seu ID

    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndice(id);
        return getMinhaLista().get(indice);
    }
// retorna o maior ID da nossa base de dados

    public int maiorID() {
        return AlunoDAO.maiorID();
    }

}
