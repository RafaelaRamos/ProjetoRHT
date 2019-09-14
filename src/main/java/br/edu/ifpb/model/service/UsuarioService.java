package br.edu.ifpb.model.service;

import br.edu.ifpb.model.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UsuarioService {

    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public Usuario autenticar(String usuario, String senha) {
        Usuario user = new Usuario();

        try {
            Query q = em.createQuery("Select u from Usuario u Where u.usuario = " + usuario + "u.senha =" + senha);
            user = (Usuario) q.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


}
