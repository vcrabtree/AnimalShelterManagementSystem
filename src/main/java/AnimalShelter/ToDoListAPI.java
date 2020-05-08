package AnimalShelter;

import java.io.IOException;
import java.util.List;

public interface ToDoListAPI {

    String check();

    void addTask(Task taskIn);

    void removeTask(String taskToRemove) throws TaskException;

    Task updateTask(String taskToUpdate, String newTaskName, int newPriority) throws IOException, TaskException;

    String getToDoList();

    void fromJson(List listin);
}
