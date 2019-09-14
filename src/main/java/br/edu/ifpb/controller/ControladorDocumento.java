package br.edu.ifpb.controller;

import lombok.Getter;
import lombok.Setter;
import br.edu.ifpb.documentos.Documento;
import br.edu.ifpb.documentos.DocumentoIF;
import br.edu.ifpb.documentos.DocPersisti;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;


@Getter
@Setter
@ManagedBean(name ="controlador")
@ViewScoped
public class ControladorDocumento {

    private DocumentoIF doc = new DocPersisti();
    private Part arquivo;
    private Documento documento;

    public void salvar() {

        doc.upload(arquivo);

    }




}
