package br.edu.ifpb.controller;

import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioIF;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named("controladorFuncionario")
public class ControladorFuncionario {
    @EJB
    private FuncionarioIF service;
    private Funcionario funcionario = new Funcionario();
    
    
    
     public String salvar(){      
        this.service.salvar(this.funcionario);
        return null;
    }
     
      public String remover(int id){
        this.service.remover(id);
        return null;
    }
    public String atualizar(){
        this.service.atualizar(funcionario);
        return null;
    }
     
    public Funcionario buscar(String cpf){
    return this.service.buscar(cpf);
    
    }
   
    public List<Funcionario> listarPorCargos(){
        return this.service.funcionariosPorcargo();
    }
    public List<Funcionario> listarAlfabetica(){
        return this.service.PorOrdemAlfabetica();
    }

   

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
