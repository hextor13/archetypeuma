package org.archetypeUma.forms;

import java.io.Serializable;

/**
 * Interface for forms.
 * 
 * @author jcisneros
 * @param <K>
 */
public interface IBaseForm<K> extends Serializable {

    /**
     * Gets an entity object from a form object
     * 
     * @return an entity object
     */
    public K toEntity();
    
    /**
     * Gets an entity object from a form object
     * 
     * @return an entity object
     */
    public K toEntity(K Entity);

    /**
     * Sets all entity's properties of this form from an entity
     * 
     * @param entity
     */
    public void fromEntity(K entity);
}
