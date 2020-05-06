package AnimalShelter;

import java.util.HashMap;

public class EmployeeCollection {
    private HashMap<String, Manager> managers;
    private HashMap<String,Volunteer> volunteers;


    public EmployeeCollection(){

        this.managers = new HashMap<>();
        this.volunteers = new HashMap<>();
    }

    public void addManager(String idM, String passwordM) throws Exception {
        if(managers.get(idM)!= null){
            throw new AccountAlreadyExistsException("Manger Already Exists");
        }
        else if(managers.size() >= 1){
            throw new LimitException("AnimalShelter.Manager count limit has been reached");
        }
        else{
            managers.put(idM, new Manager(idM, passwordM));
        }
    }

    public void addVolunteer(String idM, String passwordM) throws Exception {
        if(volunteers.get(idM)!= null){
            throw new AccountAlreadyExistsException("Volunteer Already Exists");
        }
       else{
            volunteers.put(idM, new Volunteer(idM, passwordM));
        }
    }




    public boolean checkCredentials(String ID, String password) throws AccountDoesNotExistException {
        if(managers.get(ID) == null){
            //throw new AccountDoesNotExistException(("Account doesn't exist"));
            return false;
        }
        else{
            return managers.get(ID).getPassword().equals(password);
        }
    }

    public boolean checkVolCredentials(String ID, String password) throws AccountDoesNotExistException {
        if(volunteers.get(ID) == null){
            throw new AccountDoesNotExistException((" Account doesn't exist"));
        }
        else{
            return volunteers.get(ID).getPassword().equals(password);
        }
    }


    public void deleteManagerAcct(String actID) throws IllegalArgumentException {
        if (managers.get(actID) == null || managers.size() == 0) {
            throw new IllegalArgumentException("AnimalShelter.Manager not registered in the system");
        } else {
            managers.remove(actID);
        }
    }

    public void deleteVolunteerAcct(String actID) throws IllegalArgumentException {
        if (volunteers.get(actID) == null || volunteers.size() == 0) {
            throw new IllegalArgumentException("AnimalShelter.Manager not registered in the system");
        } else {
            volunteers.remove(actID);
        }
    }

    public int getManagerCount(){
        return managers.size();
    }

    public int getVolunteerCount(){
        return volunteers.size();
    }

    public HashMap getVolMap(){return this.volunteers;}

    public HashMap getManagerMap(){return this.managers;}




}