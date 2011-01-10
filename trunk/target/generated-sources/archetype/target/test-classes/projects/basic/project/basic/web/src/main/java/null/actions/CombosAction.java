package ${package}.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ${package}.model.pojos.City;
import ${package}.service.interfaces.IUserManager;
import ${package}.utils.JsfUtils;

/**
 * Bean control to combos.
 * 
 * @author jcisneros
 */
@ManagedBean(name = "combosAction")
@SessionScoped
public class CombosAction implements Serializable {

    private static final long serialVersionUID = 1234124123412L;
    protected final Log       log              = LogFactory.getLog(getClass());

    @ManagedProperty(value = "#{userManager}")
    private IUserManager      userManager      = null;

    private List<SelectItem>  cities           = new ArrayList<SelectItem>();

    public CombosAction() {
        super();
    }

    public List<SelectItem> getCities() {
        List<City> citiesObject = userManager.getAllCity();
        try {
            cities = JsfUtils.convertListItem(citiesObject, "id", "name");
        } catch (Exception e) {
            log.error("Problem in the application...", e);
        }
        return cities;
    }

    // Getters && Setters

    public IUserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

}
