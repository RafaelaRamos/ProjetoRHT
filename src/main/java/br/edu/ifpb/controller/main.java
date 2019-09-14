package br.edu.ifpb.controller;

import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioIF;
import br.edu.ifpb.model.service.FuncionarioService;


public class main {

    public static void main(String[] args) {
        FuncionarioIF fc = new FuncionarioService();
        Funcionario f = new Funcionario("nome", "foto", "mae");
        fc.salvar(f);


    }
}
