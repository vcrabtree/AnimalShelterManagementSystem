import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolunteerTest {

    @Test
    void createVolunteer() {
        // Create Volunteer
        Volunteer v1 = new Volunteer("One", "Password");

        // Get ID and Password
        assertEquals("One", v1.getId());
        assertEquals("Password", v1.getPassword());

        // Change ID and Password
        v1.changeID("New");
        v1.changePassword("newPassword");

        // Get new ID and Password
        assertEquals("New", v1.getId());
        assertEquals("newPassword", v1.getPassword());
    }

    @Test
    public void checkAnimalStatusTest(){
            Volunteer v1 = new Volunteer("One","Password");
            AnimalList al1 = new AnimalList();
            al1.addAnimal(1,"Max","Dog","Shiba Inu","Tan","Puppy", "Male",12,1);
            al1.addAnimal(2,"Alex","Dog","German Shepard","Black","Puppy", "Female",9,2);
            al1.addAnimal(3,"Kiki","Cat","N/A","White","Kitten", "Male",11,1);
            al1.addAnimal(4,"Syd","Cat","N/A","Tan","Kitten", "Female",10,2);

            assertEquals("Available for adoption", v1.checkStatus(1,al1));
            assertEquals("Unavailable for adoption", v1.checkStatus(2,al1));
            assertEquals("Available for adoption", v1.checkStatus(3,al1));
            assertEquals("Unavailable for adoption",v1.checkStatus(4,al1));

    }


    @Test
    public void checkToDoList(){
        Volunteer v1 = new Volunteer("One","Password");
        TodoList todo = new TodoList();

        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        todo.addTask(new Task (1, "Clean Cages"));

        assertEquals("1. Feed dogs\n" +
                "2. Clean Cages\n", v1.checkToDoList(todo) );

        System.out.println(v1.checkToDoList(todo));


    }
}
