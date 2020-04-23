import java.util.Scanner;

public class ToDoListUI {
    private ToDoListAPI toDoListAPI;
    private Scanner read = new Scanner(System.in);

    public ToDoListUI(ToDoListAPI toDoListAPI){
        this.toDoListAPI = toDoListAPI;
    }

    public void toDoListAccessed(){
        read.useDelimiter("\\n");
        String action;
        String task;
        int priority;

        do {
            System.out.println("Please enter an action or type 'help' for a list of commands");
            action = read.next();
            action = action.toLowerCase();
            try {
                switch (action) {
                    case "help":
                        System.out.println("Your options are: " +
                                "\n check " +
                                "\n update " +
                                "\n add task" +
                                "\n remove task" +
                                "\n exit \n");
                        break;

                    case "check":
                        toDoListAPI.check();
                        break;

                    case "update":
                        System.out.println("Enter task to update");
                        task = read.next();
                        String taskToUpdate = task;

                        System.out.println("Enter the updated task");
                        task = read.next();
                        String taskUpdated = task;

                        System.out.println("Enter the updated priority");
                        priority = read.nextInt();
                        int newPriority = priority;

                        toDoListAPI.updateTask(task, taskUpdated, newPriority);
                        System.out.println("Task updated");
                        break;

                    case "add task":
                        System.out.println("Enter task to add");
                        task = read.next();
                        System.out.println("Enter task priority");
                        priority = read.nextInt();

                        Task newTask = new Task(priority, task);

                        toDoListAPI.addTask(newTask);
                        System.out.print("The task has been added");

                    case "remove task":
                        System.out.println("Enter a task to remove");
                        task = read.next();

                        toDoListAPI.removeTask(task);
                        System.out.println("The task has been removed");
                        break;


                    case "exit":
                        System.out.println("Thanks for checking the tasks");
                        break;

                    default:
                        System.out.println("Please enter a valid input");

                }
            }
            catch(Exception e){

            }


        } while (!action.equals("exit"));
            toDoListAccessed();


    }
}

