package org.archetypeUma.service.interfaces;

import java.io.Serializable;
import java.util.List;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IUserManager extends Serializable {

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

    /**
     * Save user.
     * 
     * @param user
     */
    @Transactional(readOnly = false)
    User save(User user, Long idCity);

    /**
     * Get user for id.
     * 
     * @param user
     */
    User getUser(Long idUser);

    // Setters for test

    void setUserDao(IUserDao userDao);

    void setCityDao(ICityDao cityDao);

}
