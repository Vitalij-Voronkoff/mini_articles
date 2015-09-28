package net.myarticles.dao.user;

import net.myarticles.model.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserByName(String userName) {
        User user = new User();
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User as u where u.userName=?").setParameter(0, userName).list();
        if ((list != null) && (list.size() > 0)) {
            user = list.get(0);
        }

        return user;
    }

    public boolean isUserExist(String userName) {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User as u where u.userName=?").setParameter(0, userName).list();
        if ((list != null) && (list.size() > 0)) {
            return true;
        } else {
            return false;
        }
    }
}
