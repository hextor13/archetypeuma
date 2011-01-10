#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.implementation;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ${package}.dao.interfaces.IBaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T, PK extends Serializable> extends
        HibernateDaoSupport implements IBaseDao<T, PK> {

    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass())
     * from Commons Logging.
     */
    protected final Log      log            = LogFactory
                                                    .getLog(this.getClass());

    @Autowired
    protected SessionFactory sessionFactory = null;

    /**
     * persistentClass.
     */
    private final Class<T>   persistentClass;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * 
     * @param sessionFactory2
     * @param sessionFactory
     * @param persistentClassP
     *            the class type you'd like to persist
     */
    public BaseDaoImpl(SessionFactory sessionFactory,
            final Class<T> persistentClassP) {
        setSessionFactory(sessionFactory);
        this.persistentClass = persistentClassP;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    /**
     * {@inheritDoc}
     */
    public final List<T> getAll() {
        List<T> result = null;
        result = getHibernateTemplate().loadAll(persistentClass);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public final T merge(T object) {
        T result = null;
        result = (T) super.getHibernateTemplate().merge(object);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public final T get(final PK id) {
        final T entity = (T) super.getHibernateTemplate().get(
                this.persistentClass, id);
        return entity;
    }
}
