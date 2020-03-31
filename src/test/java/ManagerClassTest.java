import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerClassTest {
    @Test
    public void getNeedsTest(){
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
