package AnimalShelter;


import AnimalShelter.Animal;

import java.util.Scanner;

public class VolunteerUI {

    private VolunteerAPI volunteerAPI;
    private Scanner read = new Scanner(System.in);
    private AnimalList animalListIn;

    public VolunteerUI(VolunteerAPI volunteerAPI, AnimalList animalListIn){
        this.volunteerAPI = volunteerAPI;
        this.animalListIn = animalListIn;
    }

    public void volunteerAPIAccessed(){
        read.useDelimiter("\\n");
        String action;
        String task;
        int priority;
        int id;

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
                        id = read.nextInt();
                        System.out.println(volunteerAPI.checkStatus(id, animalListIn));
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

