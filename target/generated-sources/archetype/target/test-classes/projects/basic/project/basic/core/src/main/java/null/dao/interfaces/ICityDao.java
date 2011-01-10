package ${package}.dao.interfaces;

import java.util.List;

import ${package}.model.pojos.City;

/**
 *
 * @author jcisneros
 */
public interface ICityDao extends IBaseDao<City, Long> {

    List<City> getAllCache();

}
