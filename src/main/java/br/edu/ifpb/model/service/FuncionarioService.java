
package br.edu.ifpb.model.service;
import br.edu.ifpb.model.domain.Funcionario;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FuncionarioService implements FuncionarioIF {

    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();

    public void salvar(Funcionario funcionario) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(funcionario);
        transaction.commit();
    }

    public void remover(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.remove(funcionario);
        transaction.commit();


    }

    public Funcionario buscar(int id) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Funcionario funcionario;

        funcionario = em.find(Funcionario.class, id);

        transaction.commit();
        return funcionario;
    }

    public void atualizar(Funcionario funcionario) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Funcionario funcionarioup = em.merge(funcionario);

        transaction.commit();
    }

    public List<Funcionario> funcionariosPorcargo() {
        String consultasql = "SELECT * FROM Funcionario";
        String sql = consultasql;
        Query createNativeQuery = em.createNativeQuery(sql, Funcionario.class);
        List<Funcionario> resultList = createNativeQuery.getResultList();
        return resultList;
    }

    public List<Funcionario> funcionariosPorIdade() {
        String consultasql = "SELECT * FROM Funcionario ORDER BY dataDeNascimento";
        String sql = consultasql;
        Query createNativeQuery = em.createNativeQuery(sql, Funcionario.class);
        List<Funcionario> resultList = createNativeQuery.getResultList();
        return resultList;
    }

    public List<Funcionario> funcionariosPorDepartamento(String departamento) {
        String consultasql = "SELECT * FROM Funcionario";
        String sql = consultasql;
        Query createNativeQuery = em.createNativeQuery(sql, Funcionario.class);
        List<Funcionario> resultList = createNativeQuery.getResultList();
        return resultList;
    }

    public List<Funcionario> PorOrdemAlfabetica() {

        String consultasql = "SELECT * FROM Funcionario ORDER BY nome";
        String sql = consultasql;
        Query createNativeQuery = em.createNativeQuery(sql, Funcionario.class);
        List<Funcionario> resultList = createNativeQuery.getResultList();
        return resultList;
    }

    public List<Funcionario> funcionarios() {
        String consultasql = "SELECT * FROM Funcionario";
        String sql = consultasql;
        Query createNativeQuery = em.createNativeQuery(sql, Funcionario.class);
        List<Funcionario> resultList = createNativeQuery.getResultList();
        return resultList;
    }

}
