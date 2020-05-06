package AnimalShelter;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.*;

public class TodoList implements ToDoListAPI{

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

    public void removeTask(String taskToRemove) {
        for (Object taskToLookAt : toDoList) {
            Task t = (Task) taskToLookAt;

            if (t.getTask().compareTo(taskToRemove) == 0) {
                    toDoList.remove(t);
                    this.taskCount -= 1;
            //throw exception task not int list
            }
        }
    }

    public void markTaskDone(String taskToFind) {
        for (Object taskToLookAt : toDoList) {
            Task t = (Task) taskToLookAt;

            if (t.getTask().equals(taskToFind)) {
                t.markDone();
            //throw exception task not in list/ or sting not found
            }
        }
    }

    public void updateTask(String taskToUpdate, String newTaskName, int newPriority) {

        Iterator itr = toDoList.iterator();

        while(itr.hasNext()){
            Object o = itr.next();
            Task t = (Task) o;
            if (t.getTask().equals(taskToUpdate)) {
                t.setTask(newTaskName);
                t.setPriority(newPriority);
            }
        }
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
