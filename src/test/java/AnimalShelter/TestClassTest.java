package AnimalShelter;

import AnimalShelter.Animal;
import AnimalShelter.AnimalList;
import AnimalShelter.EmptyListException;
import AnimalShelter.TestClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestClassTest {

    @Test
    public void testHello(){
        assertEquals("Hello", TestClass.printHello());
    }

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
        al1.addAnimal(21,"Dara","Dog","Collie","Black", "2","F",12,1);
        assertEquals(2,al1.getCount());

        //Search List Tests
        assertEquals(0, al1.searchList(101)); // first position in list
        assertEquals(-1, al1.searchList(3)); //not in list
        al1.addAnimal(102,"Spike", "Pantherophis guttatus","Corn Snake", "Orange","3","male",2,1);
        assertEquals(2, al1.searchList(102)); // first position in list

        //Remove AnimalShelter.Animal Tests
        al1.removeAnimal(101); //animal in list
        assertEquals(2,al1.getCount());
        assertThrows(IllegalArgumentException.class,()->al1.removeAnimal(600) ); // Illegal Argument - AnimalShelter.Animal not in list
        al1.removeAnimal(102);
        al1.removeAnimal(21);
        assertThrows(EmptyListException.class,()->al1.removeAnimal(102) ); //Empty List
    }

    @Test
    public void AnimalSearchTest(){
        AnimalList a1 = new AnimalList();
        a1.addAnimal(101,"Doodle", "Canine","Boarder Collie", "Black","3","male",15,1);
        Animal animal = a1.animalList.get(0);
        assertEquals(animal,a1.searchListA(101));
    }

//    @Test
//    public void viewAnimalList(){
//        AnimalList al1 = new AnimalList();
//        al1.addAnimal(101,"Doodle", "Canine","Boarder Collie", "Black","3","male",15,1);
//        al1.addAnimal(21,"Dara","Dog","Collie","Black", "2","F",12,1);
//        al1.addAnimal(102,"Spike", "Pantherophis guttatus","Corn Snake", "Orange","3","male",2,1);
//        assertEquals(3, al1.getCount());
//
//        System.out.println(al1.viewList());
//    }
}
