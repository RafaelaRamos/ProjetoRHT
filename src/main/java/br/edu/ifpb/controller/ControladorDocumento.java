package br.edu.ifpb.controller;


import br.edu.ifpb.documentos.Upload;
import java.io.IOException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;



@ManagedBean(name ="controlador")
@ViewScoped
public class ControladorDocumento {

  
    private Part arquivo;
  

   public void upload() throws IOException{
      

           Upload upload = Upload.getInstance();
           upload.write(this.arquivo);
          

   }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }

    
   
   
}
