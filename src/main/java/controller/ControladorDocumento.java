package main.java.controller;

import lombok.Getter;
import lombok.Setter;
import main.java.documentos.Documento;
import main.java.documentos.DocumentoIF;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
@Getter
@Setter
@ManagedBean
@ViewScoped
public class ControladorDocumento {

    private DocumentoIF doc;
    private Part arquivo;
    private Documento documento;

    public void salvar() {

        doc.upload(arquivo);

    }




}
