//import AnimalList;

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
        if(input < 1 || input > 2){
            throw new IllegalArgumentException("Please enter 1 for available or 2 for unavailable");
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
        else{
            status = "Unavailable for adoption";
            return status;
        }
    }

    public String getNeeds(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getNeeds();
    }

}
