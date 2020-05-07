package AnimalShelter;

import org.junit.jupiter.api.Test;


public class MangerLoginTest {

    @Test

    public void addneedsTest(){
    AnimalList a1 = new AnimalList();
    a1.addAnimal(3,"bb","dog", "collie", "red", "4", "m",44,4);
    EmployeeCollection ec = new EmployeeCollection();
    ManagerLogin Login = new ManagerLogin(ec);

    a1.addNeeds(3, "Needs in Manager Test");
    System.out.println(Login.getNeeds(3,a1));

    Login.addNeeds(3,"Needs from Login.addNeeds",a1);
    System.out.println(Login.getNeeds(3,a1));

    }


}
