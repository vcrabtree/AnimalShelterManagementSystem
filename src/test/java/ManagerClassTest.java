import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerClassTest {
    @Test
    public void getNeedsTest(){
        Manager m1 = new Manager("5432","pass");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        //checking if animal has any needs
        assertEquals(0, al1.searchListA(1234).needs.size());

        //adding a needs to the animal
        al1.searchListA(1234).addNeeds("change bedding");

        //checking if that need exists in the needs list
        assertEquals(1, al1.searchListA(1234).needs.size());

        System.out.println("should print 'change bedding'");
        System.out.println(m1.getNeeds(1234,al1));
    }

    @Test
    public void checkStatusTest(){
        Manager m1 = new Manager("5432","pass");
        AnimalList al1 = new AnimalList();
        al1.addAnimal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);


        assertEquals(1, m1.checkStatus(1234,al1));
    }

}
