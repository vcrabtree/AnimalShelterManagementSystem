package AnimalShelter;

import AnimalShelter.AccountDoesNotExistException;
import AnimalShelter.EmployeeCollection;
import AnimalShelter.LimitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCollectionTest {

    @Test
    void addManager() throws Exception{
        EmployeeCollection mc = new EmployeeCollection();
        assertEquals(0, mc.getManagerCount());
        mc.addManager("Amadou", "yes123");

        assertEquals(1, mc.getManagerCount());
        assertThrows(LimitException.class, ()-> mc.addManager("Kris","no123"));
        assertThrows(AccountAlreadyExistsException.class, ()-> mc.addManager("Amadou", "yes123"));
    }

    @Test
    void deleteManagerAcct() throws Exception {
        EmployeeCollection mc = new EmployeeCollection();
        mc.addManager("Amadou", "yes123");
        assertEquals(1, mc.getManagerCount());
        mc.deleteManagerAcct("Amadou");
        assertEquals(0, mc.getManagerCount());
        assertThrows(IllegalArgumentException.class, ()-> mc.deleteManagerAcct("Amadou"));
    }

    @Test
    public void testValidateCredentials() throws AccountDoesNotExistException, Exception {
        // Create AnimalShelter.Manager Account
        EmployeeCollection testCollection = new EmployeeCollection();
        testCollection.addManager("AnimalShelter.Manager", "password");

        // Incorrect Password for AnimalShelter.Manager Account
        assertFalse(testCollection.checkCredentials("AnimalShelter.Manager", "")); // no password
        assertFalse(testCollection.checkCredentials("AnimalShelter.Manager", "wrong")); // random password
        assertFalse(testCollection.checkCredentials("AnimalShelter.Manager", "pasword")); // close to correct password

        // Correct Password for AnimalShelter.Manager Account
        assertTrue(testCollection.checkCredentials("AnimalShelter.Manager", "password"));

        // Test Account That Does Not Exist
        assertThrows(AccountDoesNotExistException.class, () -> testCollection.checkCredentials("no", "password"));
    }
}