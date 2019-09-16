package br.edu.ifpb.documentos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;




public class DocPersisti {


    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public void salvar(DocumentoPDF doc) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(doc);
        transaction.commit();    }
    
}
