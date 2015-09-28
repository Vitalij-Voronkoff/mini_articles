package net.myarticle.model.userrole;

import junit.framework.TestCase;
import net.myarticles.model.userrole.UserRole;

/**
 * @author Vitalij Voronkov
 */

public class UserRoleTest extends TestCase {

    UserRole userRole = new UserRole();

    public void testSetAndGetUserRoleId() {
        assertNull(userRole.getUserRoleId());
        userRole.setUserRoleId(1);
        assertEquals(userRole.getUserRoleId(), Integer.valueOf(1));
    }

    public void testSetAndGetUserName() {
        assertNull(userRole.getUserName());
        userRole.setUserName("userName");
        assertEquals(userRole.getUserName(), "userName");
    }

    public void testSetAndGetRole() {
        assertNull(userRole.getRole());
        userRole.setRole("ROLE_USER");
        assertEquals(userRole.getRole(), "ROLE_USER");
    }
}
