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
    public void getIDTests(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(1234, a1.getId());
        System.out.println("Should print '1234'");
        System.out.println(a1.getId());
    }

    @Test
    public void getNameTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("name1", a1.getName());
        System.out.println("Should print 'name1'");
        System.out.println(a1.getName());
    }

    @Test
    public void getSpeciesTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("dog", a1.getSpecies());
        System.out.println("Should print 'dog'");
        System.out.println(a1.getBreed());
    }

    @Test
    public void getBreedTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("N/A", a1.getBreed());
        System.out.println("Should print 'N/A'");
        System.out.println(a1.getBreed());
    }

    @Test
    public void setBreedTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("N/A", a1.getBreed());
        System.out.println("Should print 'N/A'");
        System.out.println(a1.getBreed());

        a1.setBreed("dalmation");

        assertEquals("dalmation", a1.getBreed());
        System.out.println("Should print 'dalmation'");
        System.out.println(a1.getBreed());
    }

    @Test
    public void getColorTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("tan", a1.getColor());
        System.out.println("Should print 'tan'");
        System.out.println(a1.getColor());
    }

    @Test
    public void getAgeTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("puppy", a1.getAge());
        System.out.println("Should print 'puppy'");
        System.out.println(a1.getAge());
    }

    @Test
    public void setAgeTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("puppy", a1.getAge());
        System.out.println("Should print 'puppy'");
        System.out.println(a1.getAge());

        a1.setAge("adult");

        assertEquals("adult", a1.getAge());
        System.out.println("Should print 'adult'");
        System.out.println(a1.getAge());
    }

    @Test
    public void getSexTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals("male", a1.getSex());
        System.out.println("Should print 'male'");
        System.out.println(a1.getSex());
    }

    @Test
    public void getAgeWeight(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(10, a1.getWeight());
        System.out.println("Should print '10'");
        System.out.println(a1.getWeight());
    }

    @Test
    public void setWeightTest(){
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(10, a1.getWeight());
        System.out.println("Should print '10'");
        System.out.println(a1.getWeight());

        a1.setWeight(15);

        assertEquals(15, a1.getWeight());
        System.out.println("Should print '15'");
        System.out.println(a1.getWeight());
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
        assertEquals("change bedding", a1.needs.get(0));
        a1.removeNeeds("change bedding");
        assertEquals(0, a1.needs.size());
    }

    @Test
    public void getAndAddRecordsTest() {
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
        Animal a1 = new Animal(1234, "name1", "dog", "N/A", "tan", "puppy", "male", 10, 0);

        assertEquals(0, a1.getStatus());

        a1.setStatus(1);

        assertEquals(1, a1.getStatus());
    }

}
