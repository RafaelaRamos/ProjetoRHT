package br.edu.ifpb.controller;

import br.edu.ifpb.documentos.Upload;
import br.edu.ifpb.imagem.ImagemPersist;
import br.edu.ifpb.model.domain.Dependente;
import br.edu.ifpb.model.domain.Funcionario;
import br.edu.ifpb.model.service.FuncionarioService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
@SessionScoped
@Named("controladorFuncionario")
public class ControladorFuncionario implements Serializable {

    private FuncionarioService service = new FuncionarioService();
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaDeFuncionarios = new ArrayList<>();
    private Dependente dependente = new Dependente();
    //private Part file;
    private String filtro;
    private String value;
    private Part arquivo;
    private FileUploadEvent event;
    private Boolean update=false;

    /*@PostConstruct
    public void init(){
        this.listarFuncionarios();
    }*/
    public void listar() {

        if (this.filtro.equals("cargo")) {

            this.listaDeFuncionarios = this.service.funcionariosPorcargo(this.value);

        } else if (this.filtro.equals("cpf")) {

            this.listaDeFuncionarios = this.service.funcionariosPorCpf(this.value);
        } else if (this.filtro.equals("nome")) {

            this.listaDeFuncionarios = this.service.funcionariosPorNome(this.value);
        } else {
            this.listaDeFuncionarios = this.service.funcionarios();

        }

    }

    public String salvar() throws IOException {
        Upload upload = Upload.getInstance();
       // String foto = upload.write(this.file);
        //this.funcionario.setFoto(foto);
        String url = upload.write(this.arquivo);
        this.funcionario.setDocumento(url);
        this.service.salvar(this.funcionario);
        this.funcionario = new Funcionario();
        return "home.xhtml";
    }

    public String remover(long id) {
        this.service.remover(id);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(funcionario);
        this.funcionario = new Funcionario();
        return null;
    }

    public String buscar(Long id) {
        this.funcionario = this.service.buscarPorID(id);
        return "detalheFuncionario.xhtml";
    }

    public void addDependente() {
        this.funcionario.getDependentes().add(this.dependente);
        this.dependente = new Dependente();
    }

    public void removeDependente(Dependente dependente) {
        this.funcionario.getDependentes().remove(dependente);
    }

    public void listarFuncionarios() {
        this.listaDeFuncionarios = this.service.funcionarios();
    }

    public void listarCpf() {
        this.listaDeFuncionarios = this.service.funcionariosPorCpf(this.filtro);
    }

    public void listarPorCargos() {
        this.listaDeFuncionarios = this.service.funcionariosPorcargo(this.filtro);
    }

    /* public void listarAlfabetica() {
        this.listaDeFuncionarios = this.service.PorOrdemAlfabetica();
    }*/
    //public void saveFoto() {
       // this.funcionario.setFoto(ImagemPersist.upload(file));
    //}

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(List<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }

    public FuncionarioService getService() {
        return service;
    }

    public void setService(FuncionarioService service) {
        this.service = service;
    }

    public FileUploadEvent getEvent() {
        return event;
    }

    public void setEvent(FileUploadEvent event) {
        this.event = event;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }
    

}
