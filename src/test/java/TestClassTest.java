import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClassTest {

    @Test
    public void testHello(){
        assertEquals("Hello", TestClass.printHello());
    }

    @Test
    public void testValidateCredentials() throws AccountDoesNotExistException {
        // Create Manager Account
        Manager manager1 = new Manager("manager@shelter.com", "password");

        // Incorrect Password for Manager Account
        assertFalse(manager1.validateCredentials("manager@shelter.com", "")); // no password
        assertFalse(manager1.validateCredentials("manager@shelter.com", "wrong")); // random password
        assertFalse(manager1.validateCredentials("manager@shelter.com", "pasword")); // close to correct password

        // Correct Password for Manager Account
        assertTrue(manager1.validateCredentials("manager@shelter.com", "password"));

        // Test Account That Does Not Exist
        assertThrows(AccountDoesNotExistException.class, () -> manager1.validateCredentials("incorrect@shelter.com", "password"));
    }
}
