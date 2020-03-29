import java.util.HashMap;

public class EmployeeCollection {
    private HashMap<String, Manager> managers;

    public EmployeeCollection(){
        managers = new HashMap<>();
    }

    public void addManager(String idM, String passwordM) throws Exception{
        if(managers.get(idM)!= null){
            throw new IllegalArgumentException("Manger Already Exists");
        }
        else if(managers.size() >= 1){
            throw new LimitException("Manager count limit has been reached");
        }
        else{
            managers.put(idM, new Manager(idM, passwordM));
        }
    }




    public boolean checkCredentials(String ID, String password){
        if(managers.get(ID) == null){
            throw new IllegalArgumentException(("Account doesn't exist"));
        }
        else{
            return managers.get(ID).getPassword().equals(password);
        }
    }


    public void deleteManagerAcct(String actID) throws IllegalArgumentException {
        if (managers.get(actID) == null) {
            throw new IllegalArgumentException("Manager not registered in the system");
        } else {
            managers.remove(actID);
        }
    }

    public int getManagerCount(){
        return managers.size();
    }




}