package org.archetypeUma.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.archetypeUma.service.interfaces.IUserManager;

/**
 * Bean control to users.
 *
 * @author jcisneros
 */
@ManagedBean(name = "userListAction")
@RequestScoped
public class UserListAction implements Serializable {

    private static final long serialVersionUID = 1234124123412L;
    private List<SelectItem> users;
    private List<City> cities;

    @ManagedProperty(value="#{userManager}")
    private IUserManager userManager = null;


    @PostConstruct
    public void construct() {
        try {
            users = new LinkedList<SelectItem>();
            List<User> usuarios = new ArrayList<User>();
            usuarios = userManager.getAll();
            Object[] use = usuarios.toArray();
        } catch (Exception ex) {
            Logger.getLogger(UserListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void destroy() {
    	if (null != users) {
    	    users.clear();
    	    users = null;
    	}
    }

    public Object[] getCities() {
        cities = userManager.getAllCity();
        return cities.toArray();
    }

    //    @Secured ({"ROLE_ADMIN"})
    public Object[] getUsers() {
        List<User> usuarios = new ArrayList<User>();
        usuarios = userManager.getAll();
        return usuarios.toArray();
    }

    // Getters && Setters

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }
}
