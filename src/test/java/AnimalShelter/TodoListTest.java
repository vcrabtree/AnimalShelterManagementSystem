package AnimalShelter;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    public void taskConstructorTest(){
     Task t1 = new Task(1, "Clean Cages") ;
     assertEquals("Clean Cages", t1.getTask());
     assertEquals(1, t1.getPriority());
     assertFalse(t1.getDone());

     t1.markDone();
     assertTrue(t1.getDone());

    }

    @Test
    public void ToDoConstructorTest(){
        TodoList do1 = new TodoList();
        assertEquals(0,do1.taskCount);
        assertEquals(0,do1.toDoList.size());

    }
    @Test
    public void addTaskTest(){
        TodoList do1 = new TodoList();
        Task t1 = new Task(1, "Clean Cages") ;

        do1.addTask(t1);
        assertEquals(1,do1.taskCount);
        do1.addTask(new Task(1,"Lock Facility"));
        assertEquals(2,do1.taskCount);

    }
    @Test
    public void removeTaskTest() throws TaskException {
        // Create To-Do List
        TodoList todo = new TodoList();

        // Add a couple of tasks to the list
        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        Task task2 = new Task(3, "Give Lucy a bath");
        todo.addTask(task2);

        // Remove both tasks from To-Do List
        assertEquals(2, todo.taskCount);
        todo.removeTask("Feed dogs");
        assertEquals(1, todo.taskCount);
        todo.removeTask("Give Lucy a bath");
        assertEquals(0, todo.taskCount);
    }

    @Test
    /*
     * Test Script
     *
     * Test for task update
     * starts as "feed dogs"
     * change it to "feed dog 1"
     * should pass and print the change
     *
     * test for priority
     * for task "Feed dog 1" (previously "Feed dogs")
     * starting priority is 5
     * change to 2
     * should pass and print the change
     *
     * test for both
     * change "feed dog 1" back to feed dogs
     * change the priority back to 5
     * should pass and print the change
     *
     * test for a task not in the list
     * look for "feed cats"
     * should pass and print task not found
     *
    */

    public void updateTaskTest(){
        // Create To-Do List
        TodoList todo = new TodoList();

        // Add a couple of tasks to the list
        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        Task task2 = new Task(1, "Play with cats");
        todo.addTask(task2);
        Task task3 = new Task(3, "Walk dogs");
        todo.addTask(task3);
        Task task4 = new Task(4, "Take Walter to vet");
        todo.addTask(task4);



        //to feed dog 1
        Task updatedTask = new Task(task1.priority, "Feed dog 1");
        todo.updateTask("Feed dogs", "Feed dog 1",task1.priority);
        //assertEquals(updatedTask, task1);
        todo.getToDoList();

        //to priority to 2
        updatedTask = new Task(2, "Feed dog 1");
        //assertEquals(updatedTask, task1);
        todo.getToDoList();

        //back to feed dogs and priority 5
        updatedTask = new Task(2, "Feed dog 1");
        //assertEquals(updatedTask, task1);
        todo.getToDoList();

        //task not in list
        //assertEquals("Item not found on the list", todo.updateTask("Feed cats", "feed animal", 4));

    }

    @Test
    public void getToDoListTest() throws TaskException {
        // Create To-Do List
        TodoList todo = new TodoList();

        // Add a couple of tasks to the list
        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        Task task2 = new Task(1, "Play with cats");
        todo.addTask(task2);
        Task task3 = new Task(3, "Walk dogs");
        todo.addTask(task3);
        Task task4 = new Task(4, "Take Walter to vet");
        todo.addTask(task4);

        //System.out.println(todo.getToDoList());

        // Get To-Do List
        assertEquals("1. Feed dogs\n2. Take Walter to vet\n3. Walk dogs\n4. Play with cats\n", todo.getToDoList());

        // Remove a couple of tasks from To-Do List
        todo.removeTask("Take Walter to vet");
        todo.removeTask("Walk dogs");

        // Get Updates To-Do List
        assertEquals("1. Feed dogs\n2. Walk dogs\n", todo.getToDoList());
    }

    @Test
    public void checkToDoListTest(){
        // Create To-Do List
        TodoList todo = new TodoList();

        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        Task task2 = new Task(1, "Play with cats");
        todo.addTask(task2);
        Task task3 = new Task(3, "Walk dogs");
        todo.addTask(task3);
        Task task4 = new Task(4, "Take Walter to vet");
        todo.addTask(task4);

        todo.check();

//        assertEquals("Feed dogs\nTake Walter to vet\nWalk dogs\nPlay with cats\n",todo.check());
//
//        todo.removeTask("Feed dogs");
//        todo.removeTask("Play with cats");
//        todo.removeTask("Walk dogs");
//        todo.removeTask("Take Walter to vet");
//
//
//        //check for empty list
//        assertEquals("The list is empty",todo.check());

    }



}
