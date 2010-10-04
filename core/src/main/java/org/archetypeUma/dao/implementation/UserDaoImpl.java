package org.archetypeUma.dao.implementation;

import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author jcisneros
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
