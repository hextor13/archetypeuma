package org.archetypeUma.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.archetypeUma.service.interfaces.IUserManager;
import org.primefaces.model.LazyDataModel;

/**
 * Bean control to users.
 * 
 * @author jcisneros
 */
@ManagedBean(name = "userListAction")
@RequestScoped
public class UserListAction implements Serializable {

    private static final long serialVersionUID = 1234124123412L;

    private List<User>        users;

    @ManagedProperty(value = "#{userManager}")
    private IUserManager      userManager      = null;

    public UserListAction() {
        super();
    }

    public List<User> getUsers() {
        List<User> usuarios = new ArrayList<User>();
        usuarios = userManager.getAll();
        return usuarios;
    }

    // Getters && Setters

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }
}
