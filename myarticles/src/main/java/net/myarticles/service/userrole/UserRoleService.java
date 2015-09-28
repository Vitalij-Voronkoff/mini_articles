package net.myarticles.service.userrole;

import net.myarticles.model.userrole.UserRole;

/**
 * @author Vitalij Voronkov
 */

public interface UserRoleService {

    public void addRoleToUser(UserRole userRole);

    public String getUserRoleByUserName(String userName);
}
