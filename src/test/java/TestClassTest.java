import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void AnimalTests(){

        //assertEquals(1, animalList.getCount());
        Animal a1 = new Animal(101,"Spot", "Canine","Boarder Collie", "Black","3","male",15,1);
        assertEquals("Spot", a1.getName());


    }

    @Test
    public void AnimalDSTests() throws EmptyListException {
        //Constructor Test
        AnimalList al1 = new AnimalList();
        assertEquals(0,al1.getCount());

        //Get Count Test
        al1.addAnimal(101,"Doodle", "Canine","Boarder Collie", "Black","3","male",15,1);
        assertEquals(1,al1.getCount());


        //Search List Tests
        assertEquals(0, al1.searchList("Doodle")); // first position in list
        assertEquals(-1, al1.searchList("Zipper")); //not in list
        al1.addAnimal(102,"Spike", "Pantherophis guttatus","Corn Snake", "Orange","3","male",2,1);
        assertEquals(1, al1.searchList("Spike")); // first position in list

        //Remove Animal Tests
        al1.removeAnimal("Doodle"); //animal in list
        assertEquals(1,al1.getCount());
        assertThrows(IllegalArgumentException.class,()->al1.removeAnimal("Zipper") ); // Illegal Argument - Animal not in list
        al1.removeAnimal("Spike");
        assertThrows(EmptyListException.class,()->al1.removeAnimal("Zipper") ); //Empty List


    }
}
