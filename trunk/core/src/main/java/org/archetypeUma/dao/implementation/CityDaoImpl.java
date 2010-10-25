package org.archetypeUma.dao.implementation;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.model.pojos.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class test city.
 *
 * @author jcisneros
 */
@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City, Long> implements ICityDao {

    @Autowired
    public CityDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

}
