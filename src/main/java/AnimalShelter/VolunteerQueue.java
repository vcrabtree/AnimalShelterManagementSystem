package AnimalShelter;

import java.util.LinkedList;
import java.util.Queue;

public class VolunteerQueue {
    private Queue<Volunteer> queue;

    public VolunteerQueue() {
        queue = new LinkedList<>();
    }

    public void addVolunteer(String ID, String password) throws AccountAlreadyExistsException {
        Volunteer newVol = new Volunteer(ID, password);
        for (Volunteer vol : queue) {
            if (vol.getId().equals(newVol.getId())) {
                throw new AccountAlreadyExistsException("AnimalShelter.Volunteer Already Exists");
            }
        }
        queue.add(newVol);
    }

    public void removeVolunteer(String ID) throws AccountDoesNotExistException {
        boolean found = false;
        for (Volunteer vol : queue) {
            if (vol.getId().equals(ID)) {
                queue.remove(vol);
                found = true;
            }
        }
        if (!found) {
            throw new AccountDoesNotExistException(("Account doesn't exist"));
        }
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public int volunteerCount() {
        return queue.size();
    }

    public String toString() {
        String volunteerString = "";
        for (Volunteer vol : queue) {
            volunteerString += vol.getId() + "\n";
        }
        return volunteerString;
    }
}
