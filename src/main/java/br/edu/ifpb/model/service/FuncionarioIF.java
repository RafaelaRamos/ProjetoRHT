package br.edu.ifpb.model.service;


import br.edu.ifpb.model.domain.Funcionario;

import java.util.List;

public interface FuncionarioIF {

    public void salvar(Funcionario funcionario);

    public void remover(Long id);

    public Funcionario buscar(String cpf);
    
    public Funcionario buscarPorID(Long id);
    
    public void atualizar(Funcionario funcionario);

    public List<Funcionario> funcionariosPorcargo(String cargo);

    public List<Funcionario> funcionariosPorCpf(String cpf);
    public List<Funcionario> funcionariosPorNome(String nome);

    public List<Funcionario> funcionarios();

   // public List<Funcionario> PorOrdemAlfabetica();

}
