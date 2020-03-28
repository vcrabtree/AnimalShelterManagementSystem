

public class Manager {
    private String id;
    private String password;


    public Manager( String idM,  String passwordM){
        id = idM;
        password = passwordM;

    }

    public boolean validateCredentials(String name, String passwordGiven) throws AccountDoesNotExistException {
        if (name != id) {
            throw new AccountDoesNotExistException("This account does not exists");
        }
        if (passwordGiven == password) {
            return true;
        }
        else {
            return false;
        }
        //TODO add file for AccountDoesNotExistException
    }



    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

}