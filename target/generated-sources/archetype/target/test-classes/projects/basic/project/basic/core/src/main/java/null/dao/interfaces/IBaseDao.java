package ${package}.dao.interfaces;

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

    /**
     * Generic method used to get all objects of a particular type. This is the
     * same as lookup up all rows in a table.
     * 
     * @return List of populated objects
     */
    List<T> getAll();

    /**
     * Generic method to save an object - handles both update and insert.
     * 
     * @param object
     *            the object to save
     * @return the persisted object
     */
    T merge(T object);

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
     * found.
     * 
     * @param id
     *            the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    T get(PK id);

}
