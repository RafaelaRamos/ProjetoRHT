package main.java.model.service;


import main.java.model.domain.Funcionario;

import java.util.List;

public interface FuncionarioIF {

    public void salvar(Funcionario funcionario);

    public void remover(int id);

    public Funcionario buscar(int id);

    public void atualizar(Funcionario funcionario);

    public List<Funcionario> funcionariosPorcargo();

    public List<Funcionario> funcionariosPorIdade();

    public List<Funcionario> funcionariosPorDepartamento(String departamento);

    public List<Funcionario> PorOrdemAlfabetica();

}
