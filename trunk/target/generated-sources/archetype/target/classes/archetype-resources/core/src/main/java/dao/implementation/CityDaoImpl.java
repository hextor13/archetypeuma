#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.implementation;

import java.util.List;

import ${package}.dao.interfaces.ICityDao;
import ${package}.model.pojos.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
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

    /**
     * {@inheritDoc}
     */
    public List<City> getAllCache() {
        List<City> result = null;
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.setCacheQueries(true);
        result = ht.loadAll(City.class);
        return result;
    }

}
