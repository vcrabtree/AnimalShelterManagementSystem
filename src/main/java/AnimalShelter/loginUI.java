package AnimalShelter;

import java.util.Scanner;

public class loginUI {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String username = null;
        String ci;
        ManagerLogin Login = ManagerData();


        System.out.println("Welcome to Fihve Animal Shelter, please enter user Name: ");
        ci = input.next();

        if (!ci.toLowerCase().equals("quit")) {

            System.out.println("Please Enter Password: ");
            String password = input.next();
            try {
                if (Login.confirmCredentials(ci, password)) username = ci;
                else System.out.println("try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid User Name: " + ci);
            }
        }
        if (null != username) do {

            System.out.println("Select from the menu option:");
            System.out.println("1. Check animal status");
            System.out.println("2. Get animal needs");
            System.out.println("3. Add animal records");
            System.out.println("4. Remove animal needs");
            System.out.println("5. Update animal records");
            System.out.println("6. Add task");
            System.out.println("7. Add Animal");
            System.out.println("8. Remove Animal");
            System.out.println("9. Logout");
            ci = input.next().toLowerCase();
            switch (ci) {
                case "Check animal status":
                case "1":
                    try {
                        System.out.println("Enter animal id: ");
                        int aID = input.nextInt();

                        Login.checkStatus(aID, animalCollect());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Get animal needs":
                case "2":
                    try {
                        System.out.println("Enter animal id: ");
                        int aID = input.nextInt();

                        Login.getNeeds(aID, animalCollect());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add animal records":
                case "3":
                    System.out.println("Enter new record name: ");
                    String recName = input.next();
                    try {
                        Login.addRecords(recName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove animal needs":
                case "4":
                    System.out.println("Enter needs to remove: ");
                    String remvNeed = input.next();
                    try {
                        Login.removeNeeds(remvNeed);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Update animal records":
                case "5":
                    System.out.println("Enter record name: ");
                    String upRecName = input.next();
                    try {
                        Login.updateRecords(upRecName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add task":
                case "6":
                    System.out.println("Not yet implemented: ");


                    break;

            }
        } while (!ci.toLowerCase().equals("logout") && !ci.toLowerCase().equals("9"));

        username = null;
        while (true) {
            if (ci.toLowerCase().equals("quit")) break;
            System.out.println("Welcome to Fihve Animal Shelter, please enter user Name: ");
            ci = input.next();

            if (!ci.toLowerCase().equals("quit")) {

                System.out.println("Please Enter Password: ");
                String password = input.next();
                try {
                    if (Login.confirmCredentials(ci, password)) username = ci;
                    else System.out.println("try again, username or password not found.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid User Name: " + ci);
                }
            }
            if (null != username) do {

                System.out.println("Select from the menu option:");
                System.out.println("1. Check animal status");
                System.out.println("2. Get animal needs");
                System.out.println("3. Add animal records");
                System.out.println("4. Remove animal needs");
                System.out.println("5. Update animal records");
                System.out.println("6. Add task");
                System.out.println("7. Add Animal");
                System.out.println("8. Remove Animal");
                System.out.println("9. Logout");
                ci = input.next().toLowerCase();
                switch (ci) {
                    case "Check animal status":
                    case "1":
                        try {
                            System.out.println("Enter animal id: ");
                            int aID = input.nextInt();

                            Login.checkStatus(aID, animalCollect());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Get animal needs":
                    case "2":
                        try {
                            System.out.println("Enter animal id: ");
                            int aID = input.nextInt();

                            Login.getNeeds(aID, animalCollect());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Add animal records":
                    case "3":
                        System.out.println("Enter new record name: ");
                        String recName = input.next();
                        try {
                            Login.addRecords(recName);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Remove animal needs":
                    case "4":
                        System.out.println("Enter needs to remove: ");
                        String remvNeed = input.next();
                        try {
                            Login.removeNeeds(remvNeed);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Update animal records":
                    case "5":
                        System.out.println("Enter record name: ");
                        String upRecName = input.next();
                        try {
                            Login.updateRecords(upRecName);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Add task":
                    case "6":
                        System.out.println("Not yet implemented: ");


                        break;

                }
            } while (!ci.toLowerCase().equals("logout") && !ci.toLowerCase().equals("9"));

            username = null;

            System.out.println("logout successful");



        }
    }


    public static ManagerLogin ManagerData() throws Exception {
        EmployeeCollection eCollect = new EmployeeCollection();
        eCollect.addManager("m1", "123");


        return new ManagerLogin(eCollect);
    }

    public static AnimalList animalCollect() {
        AnimalList a1 = new AnimalList();
        a1.addAnimal(1, "love", "puppy", "pup", "tan", "2", "Male", 8, 1);
        a1.addNeeds(1,"shower");

        return a1;


    }

    public static TodoList currentTodo() {
        TodoList todo1 = new TodoList();
        Task t1 = new Task(1, "Clean Cages");
        Task t2;
        todo1.addTask(t1);

        return todo1;


    }
}









