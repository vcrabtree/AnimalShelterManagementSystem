package AnimalShelter;

import java.util.List;

public class ManagerLogin {
    private EmployeeCollection manager;
    List<String> records;
    List<String> needs;
    List<Task> toDoList;


    public ManagerLogin(EmployeeCollection managers){
        manager = managers;
    }



    public boolean confirmCredentials(String userid, String password) throws AccountDoesNotExistException {
        if(manager.checkCredentials(userid, password)){
            return true;
        }

        else return manager.checkVolCredentials(userid, password);

    }

    public int checkStatus(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getStatus();
    }
    public String getNeeds(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getNeeds();
    }
    public void addRecords(String newRecord){
        System.out.println("in progress, not yet implemented");

    }
    public void removeNeeds(String needsToRemove) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i).equals(needsToRemove)) {
                needs.remove(i);
            }
        }
    }
    public void updateRecords(String recordName){
        System.out.println("in progress, not yet implemented");


        }
    public void addTask(Task taskIn){
            toDoList.add(taskIn);
        }

    public EmployeeCollection getManager(){
        return this.manager;
    }

    }

