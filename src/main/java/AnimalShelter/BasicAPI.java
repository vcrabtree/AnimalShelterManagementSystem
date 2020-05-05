package AnimalShelter;

public interface BasicAPI {
    public int checkStatus(int id, AnimalList listIn);
    public void removeTask(Task taskToRemove);
    public void checkTODO();

}
