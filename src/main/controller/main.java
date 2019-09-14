package main.java.controller;

import main.java.model.domain.Funcionario;
import main.java.model.service.FuncionarioIF;
import main.java.model.service.FuncionarioService;


public class main {

    public static void main(String[] args) {
        FuncionarioIF fc = new FuncionarioService();
        Funcionario f = new Funcionario("nome", "foto", "mae");
        fc.salvar(f);


    }
}
