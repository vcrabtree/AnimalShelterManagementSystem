import java.util.ArrayList;
import java.util.List;

public class Animal {
    int ID;
    String name;
    String species;
    String breed;
    String color;
    String age;
    String sex;
    int weight;
    int status;
    List<String> records;
    List<String> needs;


    public Animal(int ID, String name, String species, String breed, String color, String age, String sex, int weight, int status) {
        this.ID = ID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.color = color;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.status = status;
        this.records = new ArrayList<String>();
        this.needs = new ArrayList<String>();
    }



    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String newBreed) {
        breed = newBreed;

    }

    public String getColor() {
        return color;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String newAge) {
        age = newAge;
    }

    public String getSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int newStatus) {
        status = newStatus;
    }

    public void getRecords() {
        for(int i=0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }
    }

    public void addRecords(String newRecord) {
        records.add(newRecord);
    }

    //not yet to be implemented
    //public void updateAllRecords() {}

    public String getNeeds() {
        for(int i=0; i < needs.size(); i++) {
            System.out.println(needs.get(i));
        }
        return null;
    }

    public void addNeeds(String newNeeds) {
        needs.add(newNeeds);
    }
    public void removeNeeds(String needsToRemove) {
        for(int i=0; i < needs.size(); i++) {
            if(needs.get(i).equals(needsToRemove)) {
                needs.remove(i);
            }
        }
    }

}
