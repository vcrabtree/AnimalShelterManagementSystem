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

}
