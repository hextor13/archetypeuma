package org.archetypeUma.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jcisneros
 */
@Entity(name = City.ENTITY_NAME)
@Table(name = City.TABLE_NAME)
public class City extends BaseObject {

    /**
     * BaseObject is Serializable, so City needs a Serial Version UID
     */
    private static final long   serialVersionUID   = 7550335133725207117L;

    public static final String  ENTITY_NAME        = "org.archetype.model.pojos.City";
    public static final String  TABLE_NAME         = "TABLE_CITY";
    private static final String ID_GENERATOR_NAME  = "GENERATOR_CITY";
    private static final String ID_SEQUENCE_NAME   = "SEQ_CITY";
    public static final String  COLUMN_NAME_ID     = "PK_CITY";
    public static final String  COLUMN_NAME_CODE   = "CODE_CITY";
    public static final String  COLUMN_NAME_NOMBRE = "NAME_CITY";

    /**
     * Clave primaria autonumérica sin significado
     */
    private Long                id;

    /**
     * Code of city
     */
    private String              code;

    /**
     * Nombre del city
     */
    private String              name;

    /**
     * Constructor protected.
     */
    protected City() {
        super();
    }

    /**
     * Default constructor.
     *
     * @param codigo
     * @param nombre
     */
    public City(String code, String nombre) {
        super();
        this.code = code;
        this.name = nombre;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = ID_GENERATOR_NAME)
    @SequenceGenerator(name = ID_GENERATOR_NAME, sequenceName = ID_SEQUENCE_NAME)
    @Column(name = City.COLUMN_NAME_ID)
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    protected void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCode() {
        return code;
    }

    /**
     * @param codigo
     *            the codigo to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setName(String name) {
        this.name = name;
    }

    // Abstracts

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        // if they are the same instance
        if (this == obj) {
            return true;
        }

        // if they are classify in different classes
        if (!(obj instanceof City)) {
            return false;
        }

        final City other = (City) obj;

        if (!getCode().equals(other.getCode())) {
            return false;
        }

        return true;

    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result += ((id == null) ? 0 : getId().hashCode());
        result = prime * result
                + ((getCode() == null) ? 0 : getCode().hashCode());

        return result;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return null;
        // new StringBuilder(this).append(COLUMN_NAME_ID,
        // getId()).append(COLUMN_NAME_CODIGO, getCodigo())
        // .append(COLUMN_NAME_NOMBRE, getNombre()).toString();
    }
}