import AnimalShelter.Task;
import AnimalShelter.TodoList;

public class ToDoListUITest {

    public static void main(String[] args){
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


        //ToDoListAPI testAPI = todo;
        //ToDoListUI testUI = new ToDoListUI(testAPI);

        //testUI.toDoListAccessed();


    }

}
