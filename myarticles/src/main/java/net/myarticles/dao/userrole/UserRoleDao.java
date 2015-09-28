package net.myarticles.dao.userrole;

import net.myarticles.model.userrole.UserRole;

/**
 * @author Vitalij Voronkov
 */

public interface UserRoleDao {

    public void addRoleToUser(UserRole userRole);

    public String getUserRoleByUserName(String userName);
}
