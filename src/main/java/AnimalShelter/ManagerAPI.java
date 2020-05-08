package AnimalShelter;

import java.io.IOException;

public interface ManagerAPI {
    public int checkStatus(int id, AnimalList listIn);
    public String getNeeds(int id, AnimalList listIn);
    public void addRecords(String newRecord);
    public void removeNeeds(String needsToRemove);
    public void updateRecords(String recordName);
    public void addTask(Task taskIn);
    public void updateTask(String taskToUpdate, String newTaskName, int newPriority);
    public void addAnimal(int ID, String name, String species, String breed, String color, String age, String sex, int weight, int status);
    public void removeAnimal(String animalID);



}
