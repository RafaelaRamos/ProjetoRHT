package br.edu.ifpb.model.service;

import br.edu.ifpb.model.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UsuarioService {

    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public Boolean autenticar(String usuario, String senha) {
        /*Usuario user = new Usuario();
        usuario= "'"+ usuario +"'";
        senha= "'"+ senha +"'";
        try {
            Query q = em.createQuery("Select u from Usuario u Where u.usuario = " + usuario + " and u.senha =" + senha);
            user = (Usuario) q.getSingleResult();
            if(user!=null){
            
            return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;*/
        
        if(usuario.equals("admin") && senha.equals("123")){
        
        return true;
        }
        else{
            return false;
        
        }
    }


}
