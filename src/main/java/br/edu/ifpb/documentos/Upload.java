/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.documentos;

import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioIF;
import br.edu.ifpb.model.service.FuncionarioService;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

/**
 *
 * @author Cliente
 */
public class Upload {

    private static final Upload INSTANCE = new Upload();
    private DocPersisti persist = new DocPersisti();
    private DocumentoPDF doc = new DocumentoPDF();
    private Funcionario f = new Funcionario();
    private FuncionarioIF service = new FuncionarioService();

    private Upload() {
    }

    public String write(Part part) throws IOException {
        String fileName = extractFileName(part);
        String filePath = "\\";

        File fileSaveDir = new File(filePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        part.write(filePath + File.separator + fileName);
        System.out.println(filePath + File.separator + fileName);
        String caminho = filePath + File.separator + fileName;
        String pasta = "C:\\payara5\\glassfish\\domains\\domain1\\generated\\jsp\\projetoRHT"+caminho;
        return pasta;
    }

    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public static Upload getInstance() {
        return INSTANCE;
    }
}
