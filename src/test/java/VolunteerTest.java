import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolunteerTest {

    @Test
    void createVolunteer() {
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

    @Test
    void volunteerQueueTest() throws AccountAlreadyExistsException, AccountDoesNotExistException {
        // Create Queue
        VolunteerQueue queue1 = new VolunteerQueue();

        // Check if Queue is Empty
        assertTrue(queue1.isEmpty());

        // Create a few Volunteers
        Volunteer v1 = new Volunteer("One", "Password");
        Volunteer v2 = new Volunteer("Two", "Password1");
        Volunteer v3 = new Volunteer("Three", "Password2");

        // Add Volunteers to the Queue
        queue1.addVolunteer(v1.getId(), v1.getPassword());
        assertEquals(1, queue1.volunteerCount());
        assertEquals("One", queue1.toString());
        queue1.addVolunteer(v2.getId(), v2.getPassword());
        assertEquals(2, queue1.volunteerCount());
        assertEquals("One, Two", queue1.toString());
        queue1.addVolunteer(v3.getId(), v3.getPassword());
        assertEquals(3, queue1.volunteerCount());
        assertEquals("One, Two, Three", queue1.toString());
        assertThrows(AccountAlreadyExistsException.class, ()-> queue1.addVolunteer(v1.getId(), v1.getPassword()));

        // Remove a Volunteers from the Queue
        queue1.removeVolunteer(v2.getId(), v2.getPassword());
        assertEquals(2, queue1.volunteerCount());
        assertEquals("One, Three", queue1.toString());
    }

}
