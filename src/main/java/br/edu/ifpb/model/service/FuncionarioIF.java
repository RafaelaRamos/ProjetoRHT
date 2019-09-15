package br.edu.ifpb.model.service;


import br.edu.ifpb.model.domain.Funcionario;

import java.util.List;

public interface FuncionarioIF {

    public void salvar(Funcionario funcionario);

    public void remover(int id);

    public Funcionario buscar(String cpf);

    public void atualizar(Funcionario funcionario);

    public List<Funcionario> funcionariosPorcargo( String cargo);

    public List<Funcionario> funcionariosPorCpf(String cpf);

    public List<Funcionario> funcionariosPorDepartamento(String departamento);

    public List<Funcionario> PorOrdemAlfabetica();

}
