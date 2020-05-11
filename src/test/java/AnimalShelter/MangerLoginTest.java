package AnimalShelter;

import org.junit.jupiter.api.Test;


public class MangerLoginTest {

    @Test

    public void addneedsTest() throws AnimalNotFound {
    AnimalList a1 = new AnimalList();
    a1.addAnimal(3,"bb","dog", "collie", "red", "4", "m",44,4);
    EmployeeCollection ec = new EmployeeCollection();
    ManagerLogin Login = new ManagerLogin(ec);

    a1.addNeeds(3, "Needs in Manager Test");
    System.out.println(Login.getNeeds(3,a1));

    Login.addNeeds(3,"Needs from Login.addNeeds",a1);
    System.out.println(Login.getNeeds(3,a1));

    }
    @Test
    public void getneedsTest() throws AnimalNotFound {
        AnimalList a1 = new AnimalList();
        a1.addAnimal(3,"bb","dog", "collie", "red", "4", "m",44,4);
        EmployeeCollection ec = new EmployeeCollection();
        ManagerLogin Login = new ManagerLogin(ec);

        a1.addRecords(3, "Records in Manager Test");
        System.out.println(Login.getRecords(3,a1));

        Login.addRecords(3,"Records from Login.addNeeds",a1);
        System.out.println(Login.getRecords(3,a1));

    }

    @Test
    public void adoptionList() throws AnimalNotFound {
        AnimalList a1 = new AnimalList();
        a1.addAnimal(3,"bb","dog", "collie", "red", "4", "m",44,4);
        a1.addAnimal(101,"Doodle", "Canine","Boarder Collie", "Black","3","male",15,3);
        a1.addAnimal(21,"Dara","Canine","Collie","Black", "2","F",12,3);
        a1.addAnimal(102,"Spike", "Pantherophis guttatus","Corn Snake", "Orange","3","male",2,3);
        EmployeeCollection ec = new EmployeeCollection();
        ManagerLogin Login = new ManagerLogin(ec);

       Login.viewAnimalAdoptionList(a1);

    }



}
