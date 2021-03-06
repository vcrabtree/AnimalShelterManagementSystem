package AnimalShelter;

import AnimalShelter.Animal;
import AnimalShelter.AnimalList;
import AnimalShelter.TodoList;

public class Volunteer {
    String id;
    String password;

    public Volunteer(String idIn,  String passwordIn) {
        this.id = idIn;
        this.password = passwordIn;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void changeID(String newID) {
        id = newID;
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }

    public String checkStatus(int id, AnimalList listIn) throws AnimalNotFound {
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        String status;
        if(animalToCheck.getStatus() == 1){
            status = "Available for adoption";
            return status;
        }
        else if(animalToCheck.getStatus() == 2){
            status = "Unavailable for adoption";
            return status;
        }
        else if(animalToCheck.getStatus() == 3){
            status = "Status 3";
            return status;
        }
        else{
            status = "Status 4";
            return status;
        }
    }

    public String checkToDoList(TodoList listIn){
       String toDoList;
       toDoList = listIn.getToDoList();
       return toDoList;

    }



    public void  markItemDone(TodoList listIn, String taskIn ){
        listIn.markTaskDone(taskIn);

    }
}
