package br.edu.ifpb.controller;

import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named("controladorFuncionario")
public class ControladorFuncionario {

    private FuncionarioService service = new FuncionarioService();
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaDeFuncionarios = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        this.listarFuncionarios();
    }

    public String salvar() {
        this.service.salvar(this.funcionario);
        return "home.xhtml";
    }

    public String remover(int id) {
        this.service.remover(id);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(funcionario);
        return null;
    }

    public String buscar(String cpf) {
        this.funcionario = this.service.buscar(cpf);
        return "detalheFuncionario.xhtml";
    }
    
    public void listarFuncionarios(){
        this.listaDeFuncionarios = this.service.funcionarios();
    }

    public void listarPorCargos() {
        this.listaDeFuncionarios = this.service.funcionariosPorcargo();
    }

    public void listarAlfabetica() {
        this.listaDeFuncionarios = this.service.PorOrdemAlfabetica();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(List<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }
    
}
