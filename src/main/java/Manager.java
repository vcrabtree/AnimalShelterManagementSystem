public class Manager {

    public String getNeeds(int id){
        Animal animalToCheck;
        animalToCheck = al1.searchList(id);
        return animalToCheck.getNeeds();
    }
}
