import AnimalShelter.Animal;

public class VolunteerUI {

    private VolunteerAPI volunteerAPI;
    private Scanner read = new Scanner(System.in);

    public VolunteerUI(VolunteerAPI volunteerAPI){
        this.volunteerAPI = volunteerAPI;
    }

    public void volunteerAPIAccessed(){
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
                                "\n check animal status" +
                                "\n check to do list" +
                                "\n check item off to do list " +
                                "\n exit \n");
                        break;

                    case "check animal status":
                        System.out.println("Enter animal ID to check");
                        task = read.next();
                        System.out.println(volunteerAPI.checkStatus(task, animalListIn));
                        break;

                    case "check to do list":
                        System.out.println(volunteerAPI.check());
                        break;

                    case "remove task":
                        System.out.println("Enter a task to remove");
                        task = read.next();

                        volunteerAPI.removeTask(task);
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
        volunteerAPIAccessed();


    }
}

