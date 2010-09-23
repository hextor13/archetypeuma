package org.archetypeUma.actions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.springframework.security.access.annotation.Secured;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dr. Spock (spock at dev.java.net)
 */
@ManagedBean(name = "projectManager")
@SessionScoped
public class ProjectManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<SelectItem> projectItems;

    @PostConstruct
    public void construct() {
        init();
    }

    @PreDestroy
    public void destroy() {
	if (null != projectItems) {
	    projectItems.clear();
	    projectItems = null;
	}
    }

    public void init() {
        try {

        } catch (Exception ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        projectItems = new LinkedList<SelectItem>();
        projectItems.add(new SelectItem(new Long(-5), "-- Select one project --"));
        projectItems.add(new SelectItem(new Long(-6), "pruebaJavi"));
    }

    @Secured ({"ROLE_ADMIN"})
    public List<SelectItem> getProjectItems() {
        return projectItems;
    }

    public void setProjectItems(List<SelectItem> projectItems) {
        this.projectItems = projectItems;
    }


    public String viewSprints() {
        return "/sprint/show";
    }

}
