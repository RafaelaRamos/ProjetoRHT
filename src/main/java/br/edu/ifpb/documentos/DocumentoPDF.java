/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.documentos;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Cliente
 */
@Entity
public class DocumentoPDF implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String caminho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
}
