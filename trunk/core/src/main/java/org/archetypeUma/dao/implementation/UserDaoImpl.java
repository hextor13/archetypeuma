package org.archetypeUma.dao.implementation;

import java.util.List;
import java.util.Map;

import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Dao for Users.
 *
 * @author jcisneros
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    /**
     * {@inheritDoc}
     */
    List<User> search(Map<String, Object> criterium) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        if (criterium.get("city") != null) {
            criteria.add(Restrictions.ilike("city", criterium.get("city").toString(),
                    MatchMode.ANYWHERE));
        }
        return getHibernateTemplate().findByCriteria(criteria);
    }
}
