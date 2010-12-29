package org.archetypeUma.forms;

/**
 * Form login user.
 * 
 * @author jcisneros
 */
public class LoginForm {

    private static final long serialVersionUID = 1234123412341234L;

    /**
     * Nick user.
     */
    private String            j_username;

    /**
     * Password user.
     */
    private String            j_password;

    // Getters && Setter

    public String getJ_username() {
        return j_username;
    }

    public void setJ_username(String j_username) {
        this.j_username = j_username;
    }

    public String getJ_password() {
        return j_password;
    }

    public void setJ_password(String j_password) {
        this.j_password = j_password;
    }

}