package org.archetypeUma.actions;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.archetypeUma.forms.LoginForm;
import org.archetypeUma.service.interfaces.IUserManager;

/**
 * Bean control to users.
 * 
 * @author jcisneros
 */
@ManagedBean(name = "loginAction")
@RequestScoped
public class LoginAction implements Serializable {

    private static final long serialVersionUID = 1234124123412L;

    @ManagedProperty(value = "#{userManager}")
    private IUserManager      userManager      = null;
    private LoginForm         loginForm        = new LoginForm();
    private Long              idUser           = null;

    public LoginAction() {
    }

    @PreDestroy
    public void destroy() {
    }

    public String done() {
        String page = "list";
        try {
        } catch (Exception e) {
        }
        return page;
    }

    // Getters && Setters

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    protected IUserManager getUserManager() {
        return userManager;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
