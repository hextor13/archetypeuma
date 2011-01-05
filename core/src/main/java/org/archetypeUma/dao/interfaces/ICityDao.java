package org.archetypeUma.dao.interfaces;

import java.util.List;

import org.archetypeUma.model.pojos.City;

/**
 *
 * @author jcisneros
 */
public interface ICityDao extends IBaseDao<City, Long> {

    List<City> getAllCache();

}
