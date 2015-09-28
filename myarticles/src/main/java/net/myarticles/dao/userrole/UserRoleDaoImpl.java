package net.myarticles.dao.userrole;

import net.myarticles.model.userrole.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRoleToUser(UserRole userRole) {
        sessionFactory.getCurrentSession().save(userRole);
    }

    public String getUserRoleByUserName(String userName) {
        UserRole userRole = new UserRole();
        List<UserRole> list = sessionFactory.getCurrentSession().createQuery("from UserRole as u where u.userName=?").setParameter(0, userName).list();
        if ((list != null) && (list.size() > 0)) {
            userRole = list.get(0);
        }
        return userRole.getRole();
    }
}
