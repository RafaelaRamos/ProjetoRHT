package main.java.documentos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.io.*;

@AllArgsConstructor
@NoArgsConstructor

public class DocPersisti implements DocumentoIF{


    private Documento documento= new Documento();
    private DocPersisti dp = new DocPersisti();
    private String nomeArquivoSaida;
    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public void salvar(Documento doc) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(doc);
        transaction.commit();
    }
    @Override
    public void upload( Part arquivo) {

        nomeArquivoSaida = "C:\\Users\\Cliente\\Desktop\\ProjetoRHT\\documentos\\"+ arquivo.getName();

        try {
            InputStream is = arquivo.getInputStream();
            OutputStream out = new FileOutputStream(nomeArquivoSaida);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = is.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            documento.setDocumento(nomeArquivoSaida);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
