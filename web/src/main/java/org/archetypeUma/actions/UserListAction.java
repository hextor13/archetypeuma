package org.archetypeUma.actions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.archetypeUma.service.interfaces.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jcisneros
 */
@ManagedBean(name = "userListAction")
@RequestScoped
public class UserListAction implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<SelectItem> users;

    @Autowired
    @Qualifier("userManager")
    private IUserManager userManager = null;


    @PostConstruct
    public void construct() {
        init();
    }

    @PreDestroy
    public void destroy() {
    	if (null != users) {
    	    users.clear();
    	    users = null;
    	}
    }

    public void init() {
        try {
            users = new LinkedList<SelectItem>();
            userManager.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setProjectItems(List<SelectItem> projectItems) {
        this.users = projectItems;
    }

//    @Secured ({"ROLE_ADMIN"})
    public List<SelectItem> getUsers() {
        return users;
    }

    public void setUsers(List<SelectItem> users) {
        this.users = users;
    }

    // Getters && Setters

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }
}
