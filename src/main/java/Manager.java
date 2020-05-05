//import AnimalList;

import java.util.List;

public class Manager {
    String id;
    String password;

    public Manager( String idM,  String passwordM) {
        id = idM;
        password = passwordM;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void updateAnimalRecords(int id, AnimalList listIn, String input){
        Animal animalToUpdate;
        animalToUpdate = listIn.searchListA(id);
        animalToUpdate.addRecords(input);
    }

    public String getRecords(int id, AnimalList listIn){
        Animal recsToGet;
        recsToGet = listIn.searchListA(id);
        String recs = "";
        for(int i = 0; i < recsToGet.records.size(); i++){
            recs += recsToGet.records.get(i) + "\n";
        }
        if(recs == ""){
            return "No records available";
        }
        else{
            return recs;
        }
    }

    public void updateAnimalStatus(int id, AnimalList listIn, int input){
        Animal animalToUpdate;
        animalToUpdate = listIn.searchListA(id);
        System.out.println("Please enter...\n1: Available for adoption \n2: Unavailable for adoption \n3: Status 3 \n4: Status 4");
        if(input < 1 || input > 4){
            throw new IllegalArgumentException("Please enter 1, 2, 3, or 4.");
        }
        else{
            animalToUpdate.setStatus(input);
        }
    }

    public String checkStatus(int id, AnimalList listIn) {
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

    public void updateAnimalNeeds(int id, AnimalList listIn, String needs){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA((id));
        animalToCheck.addNeeds(needs);
    }

    public String checkNeeds(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getNeeds();
    }

}
