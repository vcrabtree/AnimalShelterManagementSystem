import AnimalShelter.Animal;
import AnimalShelter.AnimalList;

public interface VolunteerAPI {
    public String checkStatus(int id, AnimalList listIn);

    public void removeTask(String taskToRemove);
}
