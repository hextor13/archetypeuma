package org.archetypeUma.model.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    private static final long   serialVersionUID                 = 7550335133725207118L;

    public static final String  ENTITY_NAME                      = "org.archetype.model.pojos.User";
    public static final String  TABLE_NAME                       = "TABLE_USER";
    private static final String ID_GENERATOR_NAME                = "GENERATOR_USER";
    private static final String ID_SEQUENCE_NAME                 = "SEQ_USER";
    public static final String  COLUMN_NAME_ID                   = "PK_USER";
    public static final String  COLUMN_NAME_NICK                 = "NICK_USER";
    public static final String  COLUMN_NAME_NAME                 = "NAME_USER";
    public static final String  COLUMN_NAME_PASSWORD             = "PASSWORD_USER";
    public static final String  COLUMN_NAME_CITY                 = "CITY_USER";
    public static final String  COLUMN_NAME_DATE_CREATION        = "DATE_CREATION_USER";
    public static final String  COLUMN_NAME_IMAGE                = "IMAGE_USER";
    public static final String  COLUMN_NAME_IMAGE_CONTENT_TYPE   = "IMAGE_CONTENT_TYPE_USER";
    public static final String  PROPERTY_NAME_ID                 = "id";
    public static final String  PROPERTY_NAME_NICK               = "nick";
    public static final String  PROPERTY_NAME_NAME               = "name";
    public static final String  PROPERTY_NAME_CITY               = "city";
    public static final String  PROPERTY_NAME_PASSWORD           = "password";
    public static final String  PROPERTY_NAME_IMAGE              = "image";
    public static final String  PROPERTY_NAME_IMAGE_CONTENT_TYPE = "imageContentType";
    public static final String  PROPERTY_NAME_DATE_CREATION      = "dateCreation";

    /**
     * Identity.
     */
    private Long                id;

    /**
     * Nick user.
     */
    private String              nick;

    /**
     * Code user.
     */
    private String              password;

    /**
     * User name.
     */
    private String              name;

    /**
     * City of the user.
     */
    private City                city;

    /**
     * Date by created user.
     */
    private Date                dateCreation;

    /**
     * Image the user.
     */
    private byte[]              image;

    /**
     * Image content type the user.
     */
    private String              imageContentType;

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

    /**
     * @return the nombre
     */
    @ManyToOne(targetEntity = City.class, cascade = { CascadeType.PERSIST })
    @JoinColumn(name = COLUMN_NAME_CITY)
    public City getCity() {
        return city;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the nombre
     */
    @Column(name = COLUMN_NAME_DATE_CREATION)
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = COLUMN_NAME_IMAGE)
    @Lob
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Column(name = COLUMN_NAME_IMAGE_CONTENT_TYPE, length = 50)
    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        sb.append(COLUMN_NAME_NICK).append("=").append(getNick()).append(" ");
        sb.append(COLUMN_NAME_NAME).append("=").append(getName()).append(" ")
                .toString();
        sb.append(COLUMN_NAME_NAME).append("=").append(getName()).append(" ")
                .toString();
        sb.append(COLUMN_NAME_CITY).append("=").append(getCity()).append(" ")
                .toString();
        return sb.toString();
    }
}