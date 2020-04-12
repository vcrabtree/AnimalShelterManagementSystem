import java.util.Scanner;

public class ToDoListUI {
   // private ToDoListAPI toDoListAPI;
    private Scanner read = new Scanner(System.in);

    //public toDoListUI(ToDoListAPI toDoListAPI){
    //        this.toDoListAPI = toDoListAPI;
    //    }


        public void toDoListAccessed(){
            read.useDelimiter("\\n");
            String action;
            String task;
            int priority;

            do {
                System.out.println("Please enter an action or type 'help' for a list of commands");
                action = read.next();
                action = action.toLowerCase();
                try{
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
                            ToDoListAPI.check();
                            break;


                        case "update":
                            System.out.println("Enter task to update");
                            task = read.next();
                            ToDoListAPI.update(task);
                            System.out.println("Task updated");
                            break;

                        case "add task":
                            System.out.println("Enter task task to add");
                            String task = read.next();
                            System.out.println("Enter task priority");
                            priority = read.nextInt();
                            ToDoListAPI.add(priority, task);
                            System.out.println("The task has been added");

                        case "remove task":
                            System.out.println("Enter a task to remove");
                            task = read.next();
                            ToDoListAPI.remove(task);
                            System.out.println("The task has been removed");
                            break;


                        case "exit":
                            System.out.println("Thanks for checking the tasks");
                            break;

                        default:
                            System.out.println("Please enter a valid input");


                    }
                }
                //catch(AccountFrozenException e){
                  //  System.out.println(e.getMessage());
                //}
                //catch(Exception e){
                  //  System.out.println(e.getMessage());
                //}


            } while (!action.equals("exit"));
            toDoListAccessed();

        }
    }
}
