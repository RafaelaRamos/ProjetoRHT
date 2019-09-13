package main.java.documentos;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class ServletUpload extends HttpServlet {

    /*
    private Documento documento = new Documento();
    private DocPersisti docp= new DocPersisti();

    //Initialize global variables

    public void init() throws ServletException {

    }



    //Process the HTTP Post request

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        doGet(request, response);

    }


//Process the HTTP Get request

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        boolean isMultiPart = FileUpload.isMultipartContent(request);

        if (isMultiPart) {

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            String formulario = "";

            try {

                List items = upload.parseRequest(request);

                Iterator iter = items.iterator();

                while (iter.hasNext()) {

                    FileItem item = (FileItem) iter.next();

                    if (item.getFieldName().equals("tipoForm")) {

                        formulario = item.getString();

                    }

                    if (!item.isFormField()) {

                        if (item.getName().length() > 0) {

                            this.inserirImagemDiretorio(item);

                        }

                    }

                }

            } catch (FileUploadException ex) {

                ex.printStackTrace();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }
    }
        private void inserirImagemDiretorio(FileItem item) throws IOException {


            //Pega o diretório /logo dentro do diretório atual de onde a

            //aplicação está rodando

            String caminho = getServletContext().getRealPath("/logo")

                    + "/";


            // Cria o diretório caso ele não exista

            File diretorio = new File(caminho);

            if (!diretorio.exists()) {

                diretorio.mkdir();

            }


            // Mandar o arquivo para o diretório informado

            String nome = item.getName();

            String arq[] = nome.split("\\\\");

            for (int i = 0; i < arq.length; i++) {

                nome = arq[i];

            }


            File file = new File(diretorio, nome);

            FileOutputStream output = new FileOutputStream(file);

            InputStream is = item.getInputStream();

            byte[] buffer = new byte[2048];

            int nLidos;

            while ((nLidos = is.read(buffer)) >= 0) {

                output.write(buffer, 0, nLidos);

            }

            output.flush();

            output.close();
            documento.setDocumento(caminho);
            docp.salvar(documento);
        }*/

    }




