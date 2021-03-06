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

    public int checkStatus(int id, AnimalList listIn) throws AnimalNotFound {
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getStatus();
    }
    public String getNeeds(int id, AnimalList listIn) throws AnimalNotFound {
//        Animal animalToCheck;
//        animalToCheck = listIn.searchListA(id);

        String needs;
        needs = listIn.getNeeds(id);
        return needs;
    }

    public String getRecords(int id, AnimalList listIn) throws AnimalNotFound {

        String records;
        records = listIn.getRecords(id);
        return records;
    }

    public void addNeeds(int id, String needIn, AnimalList listIn) throws AnimalNotFound {
        listIn.addNeeds(id,needIn);
            }

    public void addRecords(int id, String recordIn, AnimalList listIn) throws AnimalNotFound {
        listIn.addRecords(id,recordIn);

    }

    public void removeNeeds(String needsToRemove) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i).equals(needsToRemove)) {
                needs.remove(i);
            }
        }
    }
//    public void updateRecords(String recordName){
//        System.out.println("in progress, not yet implemented");
//
//
//        }
    public void addTask(Task taskIn){
            toDoList.add(taskIn);
        }

    public EmployeeCollection getManager(){
        return this.manager;
    }

    public void removeAnimal(int aID, AnimalList animalListIn) throws EmptyListException, AnimalNotFound {
        animalListIn.removeAnimal(aID);

    }

    public void removeNeeds(int aID, AnimalList animalListIn, String need) throws NeedNotFoundException, AnimalNotFound {
        animalListIn.removeNeeds(aID,need);
    }

    public void viewAnimalList(AnimalList animalListIn)  {
        System.out.println(animalListIn.getList());

    }

    public void viewAnimalAdoptionList(AnimalList animalListIn)  {
        System.out.println(animalListIn.getAdoptionList());
    }

    public void addTask(TodoList listIn, String taskIn, int pIn){
        Task temp = new Task(pIn,taskIn);
        listIn.addTask(temp);

    }

    public void updateTask(TodoList listIn, String taskToUpdate, String newTaskName, int newPriority) throws TaskException {
        Task temp;
        temp = listIn.updateTask(taskToUpdate, newTaskName, newPriority);
        listIn.addTask(temp);
    }


    public void viewToDo(TodoList listIn){
        listIn.check();
    }

    }

