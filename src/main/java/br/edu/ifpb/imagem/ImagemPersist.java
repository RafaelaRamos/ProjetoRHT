package br.edu.ifpb.imagem;

import br.edu.ifpb.documentos.*;
import br.edu.ifpb.documentos.Documento;
import br.edu.ifpb.documentos.DocumentoIF;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.io.*;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

@AllArgsConstructor
@NoArgsConstructor

public class ImagemPersist {


    private static Imagem imagem = new Imagem();
    private ImagemPersist dp = new ImagemPersist();
    private static String nomeArquivoSaida;
    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public void salvar(Documento doc) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(doc);
        transaction.commit();
    }

    public static String upload( Part arquivo) {

        nomeArquivoSaida = "/home/amanda/Documentos/ADS/RHT/uploads/imagens/"+ arquivo.getName();
        
        try {
            InputStream is = arquivo.getInputStream();
            OutputStream out = new FileOutputStream(nomeArquivoSaida);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = is.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            imagem.setImaagen(nomeArquivoSaida);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return nomeArquivoSaida;
    }
}
