package org.archetypeUma.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que representa un usuario.
 *
 * @author jcisneros
 */
@Entity(name = User.ENTITY_NAME)
@Table(name = User.TABLE_NAME)
public class User extends BaseObject {

    /**
     * BaseObject is Serializable, so USER needs a Serial Version UID
     */
    private static final long   serialVersionUID  = 7550335133725207118L;

    public static final String  ENTITY_NAME       = "org.archetype.model.pojos.User";
    public static final String  TABLE_NAME        = "TABLE_USER";
    private static final String ID_GENERATOR_NAME = "GENERATOR_USER";
    private static final String ID_SEQUENCE_NAME  = "SEQ_USER";
    public static final String  COLUMN_NAME_ID    = "PK_USER";
    public static final String  COLUMN_NAME_NICK  = "NICK_USER";
    public static final String  COLUMN_NAME_NAME  = "NAME_USER";

    /**
     * Clave primaria autonumérica sin significado
     */
    private Long                id;

    /**
     * Código INE
     */
    private String              nick;

    /**
     * User name.
     */
    private String              name;

    /**
     * Constructor protected.
     */
    protected User() {
        super();
    }

    /**
     * Default constructor.
     *
     * @param codigo
     * @param nombre
     */
    public User(String nick, String name) {
        super();
        this.nick = nick;
        this.name = name;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = ID_GENERATOR_NAME)
    @SequenceGenerator(name = ID_GENERATOR_NAME, sequenceName = ID_SEQUENCE_NAME)
    @Column(name = User.COLUMN_NAME_ID)
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
    @Column(name = COLUMN_NAME_NICK, length = 100)
    public String getNick() {
        return nick;
    }

    /**
     * @param codigo
     *            the codigo to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the nombre
     */
    @Column(name = COLUMN_NAME_NAME, length = 100)
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
        if (!(obj instanceof User)) {
            return false;
        }

        final User other = (User) obj;

        if (!getNick().equals(other.getNick())) {
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
                + ((getNick() == null) ? 0 : getNick().hashCode());

        return result;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(COLUMN_NAME_ID).append(getId()).append(" ");
        sb.append(COLUMN_NAME_NICK).append(getNick()).append(" ");
        sb.append(COLUMN_NAME_NAME).append(getName()).append(" ").toString();
        return sb.toString();
    }
}