package org.archetypeUma.service.interfaces;

import java.util.List;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.User;

//@Transactional(readOnly = true)
public interface IUserManager {

    /**
     *
     * @return
     */
    List<User> getAll();

    void setUserDao(IUserDao userDao);

    void setCityDao(ICityDao cityDao);

}
