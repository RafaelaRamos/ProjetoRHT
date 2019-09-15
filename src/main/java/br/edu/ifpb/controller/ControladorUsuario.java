package br.edu.ifpb.controller;

import br.edu.ifpb.model.service.UsuarioService;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


@RequestScoped
@Named("controladorLogin")
public class ControladorUsuario {
    
    
    private String email;
    private String senha;
    private UsuarioService us = new UsuarioService();
    
    public void login() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (us.autenticar(email, senha)) {
            context.getExternalContext().getSessionMap().put("usuario", email);
            try {
                context.getExternalContext().redirect("index.xhtml");
            } catch (IOException e) {
            }
        } else {

            context.addMessage(null, new FacesMessage("Usuário não registrado. Verifique email e senha"));

        }
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
}
