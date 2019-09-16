package br.edu.ifpb.controller;

import lombok.Getter;
import lombok.Setter;
import br.edu.ifpb.documentos.Upload;
import br.edu.ifpb.model.domain.Funcionario;
import java.io.IOException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;


@Getter
@Setter
@ManagedBean(name ="controlador")
@ViewScoped
public class ControladorDocumento {
 
    private Part arquivo;
    private Funcionario f = new Funcionario();
  

   public void upload() throws IOException{
      

           Upload upload = Upload.getInstance();
           upload.write(this.arquivo,this.f.getCpf());
          

   }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }





}
