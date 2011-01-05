package org.archetypeUma.forms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.archetypeUma.model.pojos.User;
import org.springframework.util.FileCopyUtils;

/**
 * Form user.
 * 
 * @author jcisneros
 */
public class UserForm implements IBaseForm<User> {

    private static final long serialVersionUID = 1234123412341234L;

    /**
     * Id user.
     */
    private Long              idUser;

    /**
     * Nick user.
     */
    private String            nick;

    /**
     * Name user.
     */
    private String            name;

    /**
     * City.
     */
    private Long              city;

    /**
     * Date creation user.
     */
    private Date              dateCreation;

    /**
     * Image the user.
     */
    private UploadedFile      image;

    /**
     * Image the user.
     */
    private byte[]            imageDB;

    public void fromEntity(final User user) {
        if (user != null) {
            setNick(user.getNick());
            setName(user.getName());
            if (user.getCity() != null) {
                setCity(user.getCity().getId());
            }
            if (user.getImage() != null) {
                setImageDB(user.getImage());
            }
            setDateCreation(user.getDateCreation());
        }
    }

    public User toEntity() {
        final User user = new User(getNick(), getName());
        toEntity(user);
        return user;
    }

    public User toEntity(final User user) {
        user.setNick(getNick());
        user.setName(getName());
        // image
        if (getImage() != null) {
            try {
                final InputStream inputS = getImage().getInputStream();
                if (inputS != null) {
                    user.setImage(FileCopyUtils.copyToByteArray(inputS));
                }
            } catch (final IOException e) {
            }
            user.setImageContentType(getImage().getContentType());
        }
        return user;
    }

    // Getters && Setter

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }

    public byte[] getImageDB() {
        return imageDB;
    }

    public void setImageDB(byte[] imageDB) {
        this.imageDB = imageDB;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
