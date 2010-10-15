package org.archetypeUma.dao.implementation;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.archetypeUma.dao.interfaces.IBaseDao;
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

    // public SessionFactory getSessionFactory() {
    // return sessionFactory;
    // }
    //
    // public void setSessionFactory(SessionFactory sessionFactory) {
    // this.sessionFactory = sessionFactory;
    // }

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

}
