import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCollectionTest {

    @Test
    void addManager() {
        EmployeeCollection mc = new EmployeeCollection();
        assertEquals(0, mc.getManagerCount());
        mc.addManager("Amadou", "yes123");
        assertEquals(1, mc.getManagerCount());
        mc.addManager("Kris", "no123");
        assertEquals(2, mc.getManagerCount());
        mc.addManager("Ritz", "ok123");
        assertEquals(3, mc.getManagerCount());

        assertThrows(IllegalArgumentException.class, ()-> mc.addManager("Amadou", "yes123"));
    }

    @Test
    void deleteManagerAcct() {
        EmployeeCollection mc = new EmployeeCollection();
        mc.addManager("Amadou", "yes123");
        mc.addManager("Kris", "no123");
        assertEquals(2, mc.getManagerCount());
        mc.deleteManagerAcct("Amadou");
        assertEquals(1, mc.getManagerCount());
        assertThrows(IllegalArgumentException.class, ()-> mc.deleteManagerAcct("Amadou"));
    }

    @Test
    public void testValidateCredentials() throws AccountDoesNotExistException {
        // Create Manager Account
        EmployeeCollection testCollection = new EmployeeCollection();
        testCollection.addManager("Manager", "password");

        // Incorrect Password for Manager Account
        assertFalse(manager1.validateCredentials("Manager", "")); // no password
        assertFalse(manager1.validateCredentials("Manager", "wrong")); // random password
        assertFalse(manager1.validateCredentials("Manager", "pasword")); // close to correct password

        // Correct Password for Manager Account
        assertTrue(manager1.validateCredentials("Manager", "password"));

        // Test Account That Does Not Exist
        assertThrows(AccountDoesNotExistException.class, () -> manager1.validateCredentials("no", "password"));
    }
}