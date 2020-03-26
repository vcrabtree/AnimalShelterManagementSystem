public class TestClass {
    public static String printHello(){
        return("Hello");
    }

    public boolean validateCredentials(String email, String password) throws AccountDoesNotExistException {
        // If there is no manager with given email {
            throw new AccountDoesNotExistException("This account does not exists");
        }
        // If the manager's password equals the inputted password {
            return true;
        }
        else {
            return false;
        }
        //TODO add file for AccountDoesNotExistException
    }
}
