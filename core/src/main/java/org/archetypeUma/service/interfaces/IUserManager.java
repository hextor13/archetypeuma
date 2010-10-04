package org.archetypeUma.service.interfaces;

import java.util.List;

import org.archetypeUma.model.pojos.User;

//@Transactional(readOnly = true)
public interface IUserManager {

    /**
     *
     * @return
     */
    List<User> getAll();

}
