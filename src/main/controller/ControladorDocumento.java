package main.java.controller;

import lombok.Getter;
import lombok.Setter;
import main.java.documentos.Documento;
import main.java.documentos.DocumentoIF;


import javax.faces.bean.ManagedBean;


@Getter
@Setter
@ManagedBean(name ="controlador")
@ViewScoped
public class ControladorDocumento {

    private DocumentoIF doc = DocPersisti();
    private Part arquivo;
    private Documento documento;

    public void salvar() {

        doc.upload(arquivo);

    }




}
