package net.myarticles.model.user;

import javax.persistence.*;

/**
 * @author Vitalij Voronkov
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USERNAME", unique = true, nullable = false, length = 45)
    private String userName;
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;
    @Column(name = "EMAIL", nullable = false, length = 45)
    private String email;
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
