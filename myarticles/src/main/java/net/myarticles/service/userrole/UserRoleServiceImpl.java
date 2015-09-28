package net.myarticles.service.userrole;

import net.myarticles.dao.userrole.UserRoleDao;
import net.myarticles.model.userrole.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vitalij Voronkov
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Transactional
    public void addRoleToUser(UserRole userRole) {
        userRoleDao.addRoleToUser(userRole);
    }

    @Transactional
    public String getUserRoleByUserName(String username) {
        return userRoleDao.getUserRoleByUserName(username);
    }
}
