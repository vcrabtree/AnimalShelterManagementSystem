<<<<<<< HEAD
package AnimalShelter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerClassTest {
    @Test
    public void getNeedsTest(){
    }

    @Test
    public void updateRecordsTest(){
        Manager mg1 = new Manager("1","password");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(123,"Oscar","dog","n/a","brown","4","Male",25,1);
        assertEquals("No records available", mg1.getRecords(123,al1));
        mg1.updateAnimalRecords(123,al1,"Received vaccinations");
        assertEquals("Received vaccinations\n",mg1.getRecords(123,al1));
    }

    @Test
    public void getRecordsTest(){
        Manager mg1 = new Manager("1", "password");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(01,"Alex", "dog", "n/a", "black", "10","female",30,2);
        mg1.updateAnimalRecords(01,al1,"Record 1");
        mg1.updateAnimalRecords(01,al1,"Record 2");
        mg1.updateAnimalRecords(01,al1,"Record 3");
        assertEquals("Record 1\nRecord 2\nRecord 3\n",mg1.getRecords(01,al1));
    }

    @Test
    public void updateStatusTest(){
        Manager manager1 = new Manager("1", "password");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(1,"Max","Dog","Shiba Inu","Tan","Puppy", "Male",12,1);
        al1.addAnimal(2,"Alex","Dog","German Shepard","Black","Puppy", "Female",9,2);

        manager1.updateAnimalStatus(1,al1,3);
        manager1.updateAnimalStatus(2,al1,4);
        assertEquals(3,al1.searchListA(1).getStatus());
        assertEquals(4,al1.searchListA(2).getStatus());

        assertThrows(IllegalArgumentException.class, ()-> manager1.updateAnimalStatus(1,al1,7));
        assertThrows(IllegalArgumentException.class, ()-> manager1.updateAnimalStatus(2,al1,0));
        assertThrows(IllegalArgumentException.class, ()-> manager1.updateAnimalStatus(1,al1,-2));
    }

    @Test
    public void checkStatusTest(){
        Manager manager1 = new Manager("1","password");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(1,"Max","Dog","Shiba Inu","Tan","Puppy", "Male",12,1);
        al1.addAnimal(2,"Alex","Dog","German Shepard","Black","Puppy", "Female",9,2);
        al1.addAnimal(3,"Kiki","Cat","N/A","White","Kitten", "Male",11,1);
        al1.addAnimal(4,"Syd","Cat","N/A","Tan","Kitten", "Female",10,2);

        assertEquals("Available for adoption", manager1.checkStatus(1,al1));
        assertEquals("Unavailable for adoption", manager1.checkStatus(2,al1));
        assertEquals("Available for adoption", manager1.checkStatus(3,al1));
        assertEquals("Unavailable for adoption", manager1.checkStatus(4,al1));
    }

}
