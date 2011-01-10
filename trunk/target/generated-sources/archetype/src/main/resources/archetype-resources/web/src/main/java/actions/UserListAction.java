#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.actions;

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

import ${package}.model.pojos.City;
import ${package}.model.pojos.User;
import ${package}.service.interfaces.IUserManager;
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

    @ManagedProperty(value = "${symbol_pound}{userManager}")
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
