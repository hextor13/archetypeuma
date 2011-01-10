#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.actions;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Default Action.
 */
public class BaseAction {

    /**
     * constants
     */
    public static final String JSF_PAGE_EXTENSION = ".xhtml";
    public static final String JSF_URL_EXTENSION  = ".html";

    /**
     * log.
     */
    protected final Log        log                = LogFactory.getLog(this
                                                          .getClass());

    // Convenience methods

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public String getParameter(final String name) {
        return getRequest().getParameter(name);
    }

    public String getBundleName() {
        return getFacesContext().getApplication().getMessageBundle();
    }

    public ResourceBundle getBundle() {
        final ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        return ResourceBundle.getBundle(getBundleName(), getRequest()
                .getLocale(), classLoader);
    }

    public String getText(final String key) {
        String message;

        try {
            message = getBundle().getString(key);
        } catch (final java.util.MissingResourceException mre) {
            log.warn("Missing key for '" + key + "'");
            return "???" + key + "???";
        }

        return message;
    }

    public String getText(final String key, final Object arg) {
        if (arg == null) {
            return this.getText(key);
        }

        final MessageFormat form = new MessageFormat(getBundle().getString(key));

        if (arg instanceof String) {
            return form.format(new Object[] { arg });
        } else if (arg instanceof Object[]) {
            return form.format(arg);
        } else {
            log.error("arg '" + arg + "' not String or Object[]");

            return "";
        }
    }

    /**
     * Servlet API Convenience method
     * 
     * @return HttpServletRequest from the FacesContext
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext()
                .getRequest();
    }

    /**
     * Servlet API Convenience method
     * 
     * @return String from the FacesContext
     */
    protected String getRequestParam(final String param) {
        String result = null;

        result = getFacesContext().getExternalContext()
                .getRequestParameterMap().get(param);

        return result;
    }

    /**
     * Servlet API Convenience method
     * 
     * @return the current user's session
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * Servlet API Convenience method
     * 
     * @return HttpServletResponse from the FacesContext
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext()
                .getResponse();
    }

    /**
     * Servlet API Convenience method
     * 
     * @return the ServletContext form the FacesContext
     */
    protected ServletContext getServletContext() {
        return (ServletContext) getFacesContext().getExternalContext()
                .getContext();
    }

    /**
     * Sort list according to which column has been clicked on.
     * 
     * @param list
     *            the java.util.List to sort
     * @return ordered list
     */
    protected List sort(final List list, String sortColumn, boolean ascending) {
        boolean nullsAreHigh = false;
        Comparator comparator = new BeanComparator(sortColumn,
                new NullComparator(nullsAreHigh));
        if (!ascending) {
            comparator = new ReverseComparator(comparator);
        }
        Collections.sort(list, comparator);
        return list;
    }

    /**
     *
     */
    protected String jsfPageToUrl(String jsfPage) {
        String result = null;
        if (jsfPage != null && jsfPage.endsWith(JSF_PAGE_EXTENSION)) {
            result = jsfPage.replaceAll(JSF_PAGE_EXTENSION, JSF_URL_EXTENSION);
        }
        return result;
    }

    /**
     *
     */
    protected String getPage() {
        final StringBuilder url = new StringBuilder(getFacesContext()
                .getExternalContext().getRequestContextPath());
        url.append(getFacesContext().getViewRoot().getViewId());
        return url.toString();
    }

    protected String getUrl() {
        return jsfPageToUrl(getPage());
    }
}
