import java.util.LinkedList;
import java.util.Queue;

public class VolunteerQueue {
    private Queue<Volunteer> queue;

    public VolunteerQueue() {
        Queue<Volunteer> queue = new LinkedList<>();
    }

    public void addVolunteer(String ID, String password) throws AccountAlreadyExistsException {
        Volunteer newVol = new Volunteer(ID, password);
        if (queue.contains(newVol)) {
            throw new AccountAlreadyExistsException("Volunteer Already Exists");
        }
        else {
            queue.add(newVol);
        }
    }

    public void removeVolunteer(String ID, String password) throws AccountDoesNotExistException {
        Volunteer volToRemove = new Volunteer(ID, password);
        if (!(queue.contains(volToRemove))) {
            throw new AccountDoesNotExistException(("Account doesn't exist"));
        }
        else {
            queue.remove(volToRemove);
        }
    }

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int volunteerCount() {
        int size = queue.size();
        return size;
    }

    public String toString() {
        String volunteerString = "";
        for (Volunteer vol : queue) {
            volunteerString += vol.toString() + ", ";
        }
        return volunteerString;
    }
}
