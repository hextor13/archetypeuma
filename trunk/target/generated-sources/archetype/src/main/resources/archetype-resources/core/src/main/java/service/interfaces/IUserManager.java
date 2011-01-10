#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.interfaces;

import java.util.List;

import ${package}.dao.interfaces.ICityDao;
import ${package}.dao.interfaces.IUserDao;
import ${package}.model.pojos.City;
import ${package}.model.pojos.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
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