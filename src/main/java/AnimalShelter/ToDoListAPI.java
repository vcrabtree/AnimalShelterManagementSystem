package AnimalShelter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public interface ToDoListAPI {

    String check();

    void addTask(Task taskIn);

    void removeTask(String taskToRemove);

    void updateTask(String taskToUpdate, String newTaskName, int newPriority) throws IOException;

    String getToDoList();

    void fromJson(List listin);
}
