package org.archetypeUma.dao.implementation;

import java.io.Serializable;
import java.util.List;

import org.archetypeUma.dao.interfaces.IBaseDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T, PK extends Serializable> extends         HibernateDaoSupport implements IBaseDao<T, PK> {

    public BaseDaoImpl(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public final List<T> getAll(Class<T> persistentClass) {
        List<T> result = null;
        HibernateTemplate ht = super.getHibernateTemplate();
        result = ht.loadAll(persistentClass);
        return result;
    }

}
