package ${package}.actions;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ${package}.forms.UserForm;
import ${package}.model.pojos.User;
import ${package}.service.interfaces.IUserManager;

/**
 * Bean control to users.
 * 
 * @author jcisneros
 */
@ManagedBean(name = "userFormAction")
@RequestScoped
public class UserFormAction implements Serializable {

    private static final long serialVersionUID = 1234124123412L;

    @ManagedProperty(value = "#{userManager}")
    private IUserManager      userManager      = null;
    private UserForm          userForm         = new UserForm();
    
    @ManagedProperty("#{param.idUser}")
    private Long              idUser           = null;

    public UserFormAction() {
    }

    @PreDestroy
    public void destroy() {
    }

    public String done() {
        String page = "list";
        try {
            User user = userForm.toEntity();
            user = userManager.save(user, userForm.getCity());
        } catch (Exception e) {
        }
        return page;
    }

    public String edit() {
        String page = "list";
        try {
            User user = null;
            if (idUser != null) {
                user = userManager.getUser(idUser);
                userForm.fromEntity(user);
                page = "form";
            }
        } catch (Exception e) {
        }
        return page;
    }

    // Getters && Setters

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
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
}
