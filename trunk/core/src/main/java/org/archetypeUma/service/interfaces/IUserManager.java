package org.archetypeUma.service.interfaces;

import java.util.List;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;

//@Transactional(readOnly = true)
public interface IUserManager {

    /**
     * Get all users.
     *
     * @return users.
     */
    List<User> getAll();

    /**
     * Get all cities.
     *
     * @return cities.
     */
    List<City> getAllCity();

    // Setters for test

    void setUserDao(IUserDao userDao);

    void setCityDao(ICityDao cityDao);

}
