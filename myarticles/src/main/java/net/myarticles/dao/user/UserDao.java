package net.myarticles.dao.user;

import net.myarticles.model.user.User;

/**
 * @author Vitalij Voronkov
 */

public interface UserDao {

    public void addUser(User user);

    public User getUserByName(String userName);

    public boolean isUserExist(String userName);
}
