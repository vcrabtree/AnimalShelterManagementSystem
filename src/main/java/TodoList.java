import java.util.*;

public class TodoList {

    int taskCount;
    //List<Task> toDoList;
    Collection<Task> toDoList;


    public TodoList() {
        this.taskCount = 0;
        this.toDoList = new PriorityQueue<>();

    }

    public String check(){
        String tasks = "";
        if(toDoList.isEmpty()){
            tasks = "The list is empty";
            System.out.println(tasks);
        }
        else{
            for(Task t : toDoList) {
                tasks = tasks + t.getTask() + "\n";
                System.out.println(t.getTask());
            }

        }
        return tasks;
    }
    public void addTask(Task taskIn) {
        this.taskCount += 1;
        toDoList.add(taskIn);
    }

    public void removeTask(Task taskToRemove) {
        this.taskCount -= 1;
        toDoList.remove(taskToRemove);
    }

    public String updateTask(String taskToUpdate, String updateType, String newTaskName, int newPriority) {


        for (Object taskToLookAt : toDoList) {
            Task t = (Task) taskToLookAt;

            if (t.getTask().equals(taskToUpdate)) {
                switch (updateType) {
                    case "task":
                        t.setTask(newTaskName);
                        break;
                    case "priority":
                        t.setPriority(newPriority);
                        break;
                    case "both":
                        t.setTask(newTaskName);
                        t.setPriority(newPriority);
                        break;
                }
                return "Task Updated";
            }
        }
        return "Item not found on the list";
    }




        public String getToDoList() {
            Iterator itr = toDoList.iterator();
            int i  = 1;

            String totalList = "";
//            for (int i = 0; i < taskCount; i++) {
//                totalList += (i + 1) + ". " + toDoList.get(i).getTask() + "\n";
//            }
            while(itr.hasNext()){
                Object o = itr.next();
                Task t = (Task) o; //cast as Task
                totalList += (i) + ". " + t.getTask() + "\n";
                i++;

            }

            return totalList;
        }

        public void fromJson(List listin){
            Iterator itr = listin.iterator();

            while(itr.hasNext()){
                Task tIn = (Task) itr.next(); //cast Object as Task
                this.toDoList.add(tIn);
            }

        }
}
