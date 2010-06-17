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
public class City {

    /**
     * BaseObject is Serializable, so City needs a Serial Version UID
     */
    private static final long   serialVersionUID   = 7550335133725207118L;

    public static final String  ENTITY_NAME        = "org.archetype.model.pojos.City";
    public static final String  TABLE_NAME         = "ADM_CITY";
    private static final String ID_GENERATOR_NAME  = "generator_adm_city";
    private static final String ID_SEQUENCE_NAME   = "SEQ_ADM_CITY";
    public static final String  COLUMN_NAME_ID     = "X_CITY";
    public static final String  COLUMN_NAME_CODIGO = "C_CITY";
    public static final String  COLUMN_NAME_NOMBRE = "T_CITY";

    /**
     * Clave primaria autonumérica sin significado
     */
    private Long                id;

    /**
     * Código INE
     */
    private String              codigo;

    /**
     * Nombre del city
     */
    private String              nombre;

    protected City() {
        super();
    }

    public City(String codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
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
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo
     *            the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

        if (!getCodigo().equals(other.getCodigo())) {
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
                + ((getCodigo() == null) ? 0 : getCodigo().hashCode());

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

    public City newInstance() {
        return new City();
    }
}