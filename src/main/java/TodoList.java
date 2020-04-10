import java.util.ArrayList;
import java.util.List;

public class TodoList {

        int taskCount;
        List<Task> toDoList;


        public TodoList(){
            this.taskCount = 0;
            this.toDoList = new ArrayList<>();

        }

        public void addTask(Task taskIn){
            this.taskCount += 1;
            toDoList.add(taskIn);
        }

        public void removeTask(Task taskToRemove) {
            this.taskCount -= 1;
            toDoList.remove(taskToRemove);
        }
}
