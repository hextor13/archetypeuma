package org.archetypeUma.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface of the DAO.
 *
 * @author jcisneros
 * @param <T>
 * @param <PK>
 */
public interface IBaseDao<T, PK extends Serializable> {

    List<T> getAll(Class<T> persistentClass);

}
