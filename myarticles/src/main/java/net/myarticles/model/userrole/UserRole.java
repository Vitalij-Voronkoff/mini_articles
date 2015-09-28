package net.myarticles.model.userrole;

import javax.persistence.*;

/**
 * @author Vitalij Voronkov
 */

@Entity
@Table(name = "USER_ROLES")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE_ID", unique = true, nullable = false)
    private Integer userRoleId;
    @Column(name = "USERNAME", nullable = false, length = 45)
    private String userName;
    @Column(name = "ROLE", nullable = false, length = 45)
    private String role;

    public UserRole() {
    }

    public UserRole(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
