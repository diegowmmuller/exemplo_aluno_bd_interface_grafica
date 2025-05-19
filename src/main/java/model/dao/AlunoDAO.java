/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;

/**
 *
 * @author Diiego
 */
public class AlunoDAO {

    public static ArrayList<Aluno> minhaLista = new ArrayList<>();

    public static ArrayList<Aluno> getMinhaLista() {
        return minhaLista;
    }

    public static void setMinhaLista(ArrayList<Aluno> minhaLista) {
        AlunoDAO.minhaLista = minhaLista;
    }

    public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorID) {
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;
    }

}
