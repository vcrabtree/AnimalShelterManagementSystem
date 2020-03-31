import AnimalList;

public class Manager {
    private String id;
    private String password;


    public Manager( String idM,  String passwordM){
        id = idM;
        password = passwordM;

    }



    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
  
    public int checkStatus(int id) {
        Animal animalToCheck;
        animalToCheck = al1.searchList(id);
        return animalToCheck.getStatus();
    }

}