package br.edu.ifpb.controller;

import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioIF;
import br.edu.ifpb.model.service.FuncionarioService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named("controladorFuncionario")
public class ControladorFuncionario {

    private FuncionarioService service = new FuncionarioService();
    private Funcionario funcionario = new Funcionario();
    private String filtro;
    private String value;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public String salvar() {
        this.service.salvar(this.funcionario);
        return null;
    }

    public String remover(int id) {
        this.service.remover(id);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(funcionario);
        return null;
    }

    public Funcionario buscar(String cpf) {
        return this.service.buscar(cpf);

    }

    public List<Funcionario> listar() {
        if (this.filtro == "cargo") {

            this.service.funcionariosPorcargo(this.value);

        } else if (this.filtro == "cpf") {

            funcionarios = this.service.funcionariosPorCpf(this.value);
        } else {
            funcionarios = this.service.funcionarios();

        }
        return funcionarios;

    }

    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
