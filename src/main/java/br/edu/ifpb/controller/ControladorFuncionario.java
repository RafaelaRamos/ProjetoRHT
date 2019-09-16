package br.edu.ifpb.controller;

import br.edu.ifpb.imagem.ImagemPersist;
import br.edu.ifpb.model.domain.Dependente;
import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioService;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.Part;

@SessionScoped
@Named("controladorFuncionario")
public class ControladorFuncionario implements Serializable{

    private FuncionarioService service = new FuncionarioService();
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaDeFuncionarios = new ArrayList<>();
    private Dependente dependente = new Dependente();
    private Part file;
    
    @PostConstruct
    public void init(){
        this.listarFuncionarios();
    }

    public String salvar() {
        this.service.salvar(this.funcionario);
        this.funcionario = new Funcionario();
        return "home.xhtml";
    }

    public String remover(int id) {
        this.service.remover(id);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(funcionario);
        this.funcionario = new Funcionario();
        return null;
    }

    public String buscar(String cpf) {
        this.funcionario = this.service.buscar(cpf);
        return "detalheFuncionario.xhtml";
    }
    
    public void addDependente(){
        this.funcionario.getDependentes().add(this.dependente);
        this.dependente = new Dependente();
    }

    public void removeDependente(Dependente dependente){
        this.funcionario.getDependentes().remove(dependente);
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
    
    public void saveFoto(){
        this.funcionario.getFoto().setImaagen(ImagemPersist.upload(file));
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

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
       
}
