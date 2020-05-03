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
            if (vol.getId() == newVol.getId()) {
                throw new AccountAlreadyExistsException("Volunteer Already Exists");
            }
        }
        queue.add(newVol);
    }

    public void removeVolunteer(String ID) throws AccountDoesNotExistException {
        boolean found = false;
        for (Volunteer vol : queue) {
            if (vol.getId() == ID) {
                queue.remove(vol);
                found = true;
            }
        }
        if (found == false) {
            throw new AccountDoesNotExistException(("Account doesn't exist"));
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
            volunteerString += vol.getId() + "\n";
        }
        return volunteerString;
    }
}
