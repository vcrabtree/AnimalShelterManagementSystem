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
    public void removeTaskTest() {
        // Create To-Do List
        TodoList todo = new TodoList();

        // Add a couple of tasks to the list
        Task task1 = new Task(5, "Feed dogs");
        todo.addTask(task1);
        Task task2 = new Task(3, "Give Lucy a bath");
        todo.addTask(task2);

        // Remove both tasks from To-Do List
        assertEquals(2, todo.taskCount);
        todo.removeTask(task1);
        assertEquals(1, todo.taskCount);
        todo.removeTask(task2);
        assertEquals(0, todo.taskCount);
    }

}
