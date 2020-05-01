public class Volunteer {
    String id;
    String password;

    public Volunteer(String idIn,  String passwordIn) {
        this.id = idIn;
        this.password = passwordIn;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void changeID(String newID) {
        id = newID;
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }
}
