package br.edu.ifpb.imagem;

import java.awt.image.BufferedImage;
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
    private static String nomeArquivoSaida;
    EntityManager em = Persistence.createEntityManagerFactory("RHT").createEntityManager();


    public void salvar(Imagem doc) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(doc);
        transaction.commit();
    }

    public static String upload( Part arquivo) {

        //nomeArquivoSaida = "/home/amanda/Documentos/ADS/RHT/uploads/imagens/"+ arquivo.getName();
        File diretorio = new File("/home/amanda/Documentos/ADS/RHT/uploads/imagens/");
        
        try {
            
            InputStream input = arquivo.getInputStream();
            BufferedImage imagem = ImageIO.read(input);

            
            System.out.println("Diretorio: " + diretorio);

            if (!diretorio.exists()) {
                diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
            }

            ImageIO.write(imagem, "jpg", new File(diretorio + arquivo.getName() + ".jpg"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return diretorio + arquivo.getName();
    }
}
