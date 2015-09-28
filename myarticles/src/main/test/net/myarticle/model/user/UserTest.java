package net.myarticle.model.user;

import junit.framework.TestCase;
import net.myarticles.model.user.User;

/**
 * @author Vitalij Voronkov
 */

public class UserTest extends TestCase {

    User user = new User();

    public void testSetAndGetUserName() {
        assertNull(user.getUserName());
        user.setUserName("UserName");
        assertEquals(user.getUserName(), "UserName");
    }

    public void testSetAndGetPassword() {
        assertNull(user.getPassword());
        user.setPassword("password");
        assertEquals(user.getPassword(), "password");
    }

    public void testSetAndGetEmail() {
        assertNull(user.getEmail());
        user.setEmail("email");
        assertEquals(user.getEmail(), "email");
    }

    public void testSetAndIsEnabled() {
        assertEquals(user.isEnabled(), false);
        user.setEnabled(true);
        assertEquals(user.isEnabled(), true);
    }
}
