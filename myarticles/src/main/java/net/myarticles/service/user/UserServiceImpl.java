package net.myarticles.service.user;

import net.myarticles.dao.user.UserDao;
import net.myarticles.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vitalij Voronkov
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Transactional
    public boolean isUserExist(String userName) {
        return userDao.isUserExist(userName);
    }
}
