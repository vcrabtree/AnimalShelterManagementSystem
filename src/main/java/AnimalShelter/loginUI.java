package AnimalShelter;

import java.util.Scanner;

public class loginUI {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String username = null;
        String ci;
        ManagerLogin Login = ManagerData();
        AnimalList list1 = animalCollect();
        //TodoList tdList = currentTodo();
        TodoList tdList = new TodoList();

        System.out.println("Welcome to Five Animal Shelter, please enter user Name: ");
        ci = input.next();

        if (!ci.toLowerCase().equals("quit")) {

            System.out.println("Please Enter Password: ");
            String password = input.next();

            //manager /volunteer screens
            try {
                if (Login.confirmCredentials(ci, password)) username = ci;
                else System.out.println("try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid User Name: " + ci);
            }
        }

        boolean volunteer;
        volunteer = Login.getManager().getVolMap().containsKey(ci);


        if (null != username && !volunteer) do {
            System.out.println("MANAGER VIEW:");
            System.out.println("Select from the menu option:");
            System.out.println("1. Check animal status"); //done
            System.out.println("2. Get animal needs"); //done
            System.out.println("2a. Add animal needs"); //done
            System.out.println("3. Add animal records"); //done
            System.out.println("4. Remove animal needs");
            //System.out.println("5. Update animal records");
            System.out.println("5. View Animal List"); //done
            System.out.println("6. Add task");//done
            System.out.println("6a. Update task");
            System.out.println("6b. View To-Do List");//done
            System.out.println("7. Add Animal"); //done
            System.out.println("8. Remove Animal"); //done
            System.out.println("9. Logout"); //done
            ci = input.next().toLowerCase();
            switch (ci) {
                case "Check animal status":
                case "1":
                    try {
                        System.out.println("Enter animal id: ");
                        int aID = input.nextInt();
                        /**
                         * Should print animal status- currently lists number
                         */
                        int stat = Login.checkStatus(aID, list1);

                        if(stat == 1){
                            System.out.println("Status 1: Intake");
                        }

                        if(stat == 2){
                            System.out.println("Status 2: Staff ONLY");
                        }

                        if(stat == 3){
                            System.out.println("Status 3: Ready for Adoption");
                        }

                        if(stat == 4){
                            System.out.println("Status 4: Adopted");
                        }



                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    catch(NullPointerException e){
                        System.out.println("Animal ID Not in the system, please enter valid ID");
                    }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;
                case "Get animal needs":
                case "2":
                    try {
                        System.out.println("Enter animal id: ");
                        int aID = input.nextInt();

                        System.out.println(Login.getNeeds(aID, list1));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e){
                        System.out.println("Animal ID is not valid");
                    }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;
                case "Add animal needs":
                case "2a":
                    try {
                        System.out.println("Enter animal id: ");
                        int aID = input.nextInt();

                        System.out.println("Enter animal need: ");
                        String needIn = input.next();

                        Login.addNeeds(aID,needIn,list1);



                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e){
                        System.out.println("Animal ID is not valid");
                    }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;


                case "Add animal records":
                case "3":
                    System.out.println("Enter animal ID: ");
                    int aID = input.nextInt();

                    System.out.println("Enter record: ");
                    String recName = input.next();
                    try {
                        Login.addRecords(aID,recName,list1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;
                case "Remove animal needs":
                case "4":
                    System.out.println("Enter animalID: ");
                    int IDin= input.nextInt();
                    System.out.println("Enter needs to remove: ");
                    String remvNeed = input.next();
                    try {
                        Login.removeNeeds(IDin,list1,remvNeed);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (NeedNotFoundException e){
                        System.out.println("Need Not Found");
                    }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;
                //case "Update animal records":
                case "View Animal List":
                case "5":
                    Login.viewAnimalList(list1);
//                    System.out.println("Enter record name: ");
//                    String upRecName = input.next();
//                    try {
//                        Login.updateRecords(upRecName);
//                    } catch (IllegalArgumentException e) {
//                        System.out.println(e.getMessage());
//                    }
                    break;
                case "Add task":
                case "6":
                    System.out.println("Enter Task: ");
                    String task = input.next();

                    System.out.println("Enter Task Priority: ");
                    int prior = input.nextInt();

                    Login.addTask(tdList,task,prior);


                    break;
                case "Update task":
                case "6a":
                    System.out.println("Enter task to update: ");
                    String taskToUpdate = input.next();

                    System.out.println("Enter the updated task: ");
                    String taskUpdated = input.next();

                    System.out.println("Enter the updated priority: ");
                    int newPriority = input.nextInt();

                    Login.updateTask(tdList, taskToUpdate, taskUpdated, newPriority);
                    System.out.println("Task updated");
                    break;

                case "View To-Do List":
                case "6b":
                    Login.viewToDo(tdList);


                    break;




                case "Add Animal":
                case "7":
                    System.out.println("Enter animal ID number: ");
                    int ID = input.nextInt();
                    System.out.println("Enter animal name: ");
                    String name = input.next();
                    System.out.println("Enter species: ");
                    String species = input.next();
                    System.out.println("Enter breed: ");
                    String breed = input.next();
                    System.out.println("Enter color: ");
                    String color = input.next();
                    System.out.println("Enter age: ");
                    String age = input.next();
                    System.out.println("Enter sex: ");
                    String sex = input.next();
                    System.out.println("Enter weight: ");
                    int weight = input.nextInt();
                    System.out.println("Enter status (enter 1 for intake): 1 ");
                    int status = input.nextInt();

                    list1.addAnimal(ID,name,species,breed,color,age,sex,weight,status);

                    System.out.println(name + " has been added to the Animal List. There are currently " + list1.animalCount +" animals in the shelter list");
                    Login.viewAnimalList(list1);
                    break;
                case "Remove Animal":
                case "8":
                    System.out.println("Enter animal ID: ");
                    int anID = input.nextInt();
                    try {
                        Login.removeAnimal(anID,list1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                     catch(EmptyListException e){
                        System.out.println("Animal List is Empty");
                     }
                    catch(AnimalNotFound e){
                        System.out.println("**Animal ID is invalid, this animal is not in the system**");
                        System.out.println("Shelter Animals: ");
                        Login.viewAnimalList(list1);
                    }
                    break;
            }
        } while (!ci.toLowerCase().equals("logout") && !ci.toLowerCase().equals("9"));

        if (null != username && volunteer) do {

            System.out.println("Volunteer Welcome Screen // Imp. Volunteer UI Here");

            /**
             * implement volunteer UI code to run here
             *
             */

            ci = "9";//infinite loop otherwise



        }while (!ci.toLowerCase().equals("logout") && !ci.toLowerCase().equals("9"));

//        username = null;
//        while (true) {
//            if (ci.toLowerCase().equals("quit")) break;
//            System.out.println("Welcome to Fihve Animal Shelter, please enter user Name: ");
//            ci = input.next();
//
//            if (!ci.toLowerCase().equals("quit")) {
//
//                System.out.println("Please Enter Password: ");
//                String password = input.next();
//                try {
//                    if (Login.confirmCredentials(ci, password)) username = ci;
//                    else System.out.println("try again, username or password not found.");
//
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Invalid User Name: " + ci);
//                }
//            }
//            if (null != username) do {
//
//                System.out.println("Select from the menu option:");
//                System.out.println("1. Check animal status");
//                System.out.println("2. Get animal needs");
//                System.out.println("3. Add animal records");
//                System.out.println("4. Remove animal needs");
//                System.out.println("5. Update animal records");
//                System.out.println("6. Add task");
//                System.out.println("7. Add Animal");
//                System.out.println("8. Remove Animal");
//                System.out.println("9. Logout");
//                ci = input.next().toLowerCase();
//                switch (ci) {
//                    case "Check animal status":
//                    case "1":
//                        try {
//                            System.out.println("Enter animal id: ");
//                            int aID = input.nextInt();
//
//                            Login.checkStatus(aID, animalCollect());
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case "Get animal needs":
//                    case "2":
//                        try {
//                            System.out.println("Enter animal id: ");
//                            int aID = input.nextInt();
//
//                            Login.getNeeds(aID, animalCollect());
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case "Add animal records":
//                    case "3":
//                        System.out.println("Enter new record name: ");
//                        String recName = input.next();
//                        try {
//                            Login.addRecords(recName);
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case "Remove animal needs":
//                    case "4":
//                        System.out.println("Enter needs to remove: ");
//                        String remvNeed = input.next();
//                        try {
//                            Login.removeNeeds(remvNeed);
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case "Update animal records":
//                    case "5":
//                        System.out.println("Enter record name: ");
//                        String upRecName = input.next();
//                        try {
//                            Login.updateRecords(upRecName);
//                        } catch (IllegalArgumentException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case "Add task":
//                    case "6":
//                        System.out.println("Not yet implemented: ");
//
//
//                        break;
//
//                }
//            } while (!ci.toLowerCase().equals("logout") && !ci.toLowerCase().equals("9"));
//
//            username = null;
//
//            System.out.println("logout successful");


       // }
    }


    public static ManagerLogin ManagerData() throws Exception {
        EmployeeCollection eCollect = new EmployeeCollection();
        eCollect.addManager("m1", "123");
        eCollect.addVolunteer("c1","222");


        return new ManagerLogin(eCollect);
    }

    public static AnimalList animalCollect() {
        AnimalList a1 = new AnimalList();
        a1.addAnimal(1, "love", "puppy", "pup", "tan", "2", "Male", 8, 3);
        //a1.addNeeds(1,"shower");

        return a1;
    }

    public static TodoList currentTodo() {
        TodoList todo1 = new TodoList();
        //Task t1 = new Task(1, "Clean Cages");
        Task t2 = new Task(4,"Administer Medication");
        //todo1.addTask(t1);
        todo1.addTask(t2);

        return todo1;


    }
}









