package br.edu.ifpb.imagem;

import br.edu.ifpb.documentos.*;
import javax.servlet.http.Part;

public interface ImagemIF {

    public void upload(Part arquivo);
}

