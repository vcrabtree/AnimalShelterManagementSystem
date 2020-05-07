package AnimalShelter;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AnimalList {
    int animalCount;
    List<Animal> animalList;
    Animal a1;


    public AnimalList(){
        this.animalCount = 0;
        this.animalList = new ArrayList<>();

    }

    public void addAnimal(int ID, String name, String species, String breed, String color, String age, String sex, int weight, int status){
        Animal temp = new Animal(ID,name,species,breed,color,age,sex,weight,status);
        this.animalList.add(temp);
        this.animalCount += 1;

    }

    public int getCount(){return animalCount;}

    public void removeAnimal(int ID) throws EmptyListException {
        if(animalCount<= 0){
            throw new EmptyListException("No animals in list");
        }
        else if(searchList(ID) == -1){
            throw new IllegalArgumentException("No animal by that name");
        }
        else{
            animalCount -= 1;
            animalList.remove(searchList(ID));

        }

    }


    public int searchList(int ID){
        for(int i = 0; i < animalList.size();i++){
            if(animalList.get(i).getId()==(ID) ){
                return i;
            }
        }
        return -1;
    }

    public Animal searchListA(int ID){
        int i = searchList(ID);
        if(i != -1){
            return animalList.get(i);
        }
        else{
        return null;}
    }

    public String getNeeds(int ID){
        int i = searchList(ID);
        if(i != -1){
            return animalList.get(i).getNeeds();
        }
        else{
            return null;}
    }

    //Testing get needs for UI

    public void addNeeds(int aID, String newNeeds) {
        if (searchListA(aID) == null) {
            throw new IllegalArgumentException("animal not in the system");
        } else {
            searchListA(aID).needs.add(newNeeds);
            System.out.println("Need: " + newNeeds + " Added to: " + searchListA(aID).getName());

        }


    }

//    public String viewList(){
//        String anList = "Name\t ID\n";
//        Iterator<Animal> itr = animalList.iterator();
//
//        while(itr.hasNext()){
//            anList = anList + itr.next().getName() + "\t" + itr.next().getId() + "\n";
//         }
//
//
//        return anList;
//
//    }

}