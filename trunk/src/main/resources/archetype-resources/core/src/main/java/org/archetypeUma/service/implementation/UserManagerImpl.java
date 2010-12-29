package org.archetypeUma.service.implementation;

import java.util.Date;
import java.util.List;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.archetypeUma.service.interfaces.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service from users.
 * 
 * @author jcisneros
 */
@Service(value = "userManager")
public class UserManagerImpl implements IUserManager {

    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao = null;

    @Autowired
    @Qualifier("cityDao")
    private ICityDao cityDao = null;

    /**
     * {@inheritDoc}
     */
    public List<User> getAll() {
        return userDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public List<City> getAllCity() {
        return cityDao.getAllCache();
    }

    /**
     * {@inheritDoc}
     */
    public User save(User user, Long idCity) {
        City city = cityDao.get(idCity);
        user.setCity(city);
        user.setDateCreation(new Date());
        return userDao.merge(user);
    }

    /**
     * {@inheritDoc}
     */
    public User getUser(Long idUser) {
        return userDao.get(idUser);
    }

    // Getters && Setters

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void setCityDao(ICityDao cityDao) {
        this.cityDao = cityDao;
    }
}
