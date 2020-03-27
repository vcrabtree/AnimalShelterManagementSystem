import AnimalList;
public class Manager {
    public int checkStatus(int id) {
        Animal animalToCheck;
        animalToCheck = al1.searchList(id);
        return animalToCheck.getStatus();
    }
}
