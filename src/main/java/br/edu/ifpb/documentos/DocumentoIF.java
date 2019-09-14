package br.edu.ifpb.documentos;

import javax.servlet.http.Part;

public interface DocumentoIF {

    public void upload(Part arquivo);
}

