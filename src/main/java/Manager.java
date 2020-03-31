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

    public int checkStatus(int id, AnimalList listIn) {
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getStatus();
    }

    public String getNeeds(int id, AnimalList listIn){
        Animal animalToCheck;
        animalToCheck = listIn.searchListA(id);
        return animalToCheck.getNeeds();
    }

}
