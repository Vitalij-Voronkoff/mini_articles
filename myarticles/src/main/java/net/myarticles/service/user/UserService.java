package net.myarticles.service.user;

import net.myarticles.model.user.User;

/**
 * @author Vitalij Voronkov
 */

public interface UserService {

    public void addUser(User user);

    public User getUserByName(String userName);

    public boolean isUserExist(String userName);
}
