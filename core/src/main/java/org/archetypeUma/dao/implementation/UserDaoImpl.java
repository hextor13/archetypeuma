package org.archetypeUma.dao.implementation;

import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author jcisneros
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {

//    private SessionFactory sessionFactory;

//    public UserDaoImpl() {
//        super(User.class);
//    }
//
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }


//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Autowired
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);
    }

}
