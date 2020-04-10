import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalClassTest {
    @Test
    public void ConstructorTest() {
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(1234, a1.ID);
        assertEquals("name1", a1.name);
        assertEquals("dog", a1.species);
        assertEquals("N/A", a1.breed);
        assertEquals("tan", a1.color);
        assertEquals("puppy", a1.age);
        assertEquals("male", a1.sex);
        assertEquals(10, a1.weight);
        assertEquals(0, a1.status);
    }

    @Test
    public void getAndAddNeedsTest() {
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(0, a1.needs.size());
        a1.addNeeds("change bedding");
        assertEquals(1, a1.needs.size());
        assertEquals("change bedding", a1.needs.get(0));

        System.out.println("Should print 'change bedding'");
        a1.getNeeds();
    }

    @Test
    public void removeNeedsTest() {
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(0, a1.needs.size());
        a1.addNeeds("change bedding");
        assertEquals(1, a1.needs.size());
        a1.removeNeeds("change bedding");
    }

    @Test
    public void getAndUpdateRecordsTest() {
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(0, a1.records.size());
        a1.addRecords("shots");
        assertEquals(1, a1.records.size());
        assertEquals("shots", a1.records.get(0));

        System.out.println("Should print 'shots'");
        a1.getRecords();
    }

    @Test
    public void getAndSetStatusTest() {
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 1);
        Animal a2 = new Animal(5678, "name2", "cat", "N/A", "black", "kitten", "male", 8, 2);
        assertEquals(1, a1.getStatus());
        assertEquals(2, a2.getStatus());
        a1.setStatus(2);
        a2.setStatus(1);
        assertEquals(2, a1.getStatus());
        assertEquals(1, a2.getStatus());
    }

}
