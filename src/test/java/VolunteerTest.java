import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolunteerTest {

    @Test
    void createVolunteer() throws Exception{
        // Create Volunteer
        Volunteer v1 = new Volunteer("One", "Password");

        // Get ID and Password
        assertEquals("One", v1.getId());
        assertEquals("Password", v1.getPassword());

        // Change ID and Password
        v1.changeID("New");
        v1.changePassword("newPassword");

        // Get new ID and Password
        assertEquals("New", v1.getId());
        assertEquals("newPassword", v1.getPassword());
    }
}
