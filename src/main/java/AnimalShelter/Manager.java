package AnimalShelter;//import AnimalShelter.AnimalList;


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

    public String getNeeds(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getNeeds();
    }

    public boolean checkCredentials(String ID, String password){
        return false;
    }

}
