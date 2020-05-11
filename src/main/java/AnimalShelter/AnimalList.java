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

    public void removeAnimal(int ID) throws EmptyListException, AnimalNotFound {
        if(animalCount<= 0){
            throw new EmptyListException("No animals in list");
        }
        else if(searchList(ID) == -1){
             throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");
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

    public Animal searchListA(int ID) throws AnimalNotFound {
        int i = searchList(ID);
        if(i != -1){
            return animalList.get(i);
        }
        else{
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");}
    }

    public String getNeeds(int ID) throws AnimalNotFound {
        int i = searchList(ID);
        if(i != -1){
            return animalList.get(i).getNeeds();
        }
        else{
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");
        }
    }

    public void removeNeeds(int ID, String needRem) throws NeedNotFoundException, AnimalNotFound {
        int i = searchList(ID);
        if(i != -1){
            animalList.get(i).removeNeeds(needRem);
        }
        else{
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");} //animal not found
    }

    //Testing get needs for UI

    public void addNeeds(int aID, String newNeeds) throws AnimalNotFound {
        if (searchListA(aID) == null) {
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");
        } else {
            searchListA(aID).needs.add(newNeeds);
            System.out.println("Need: " + newNeeds + " Added to: " + searchListA(aID).getName());

        }


    }

    public void addRecords(int aID, String recordIn) throws AnimalNotFound {
        if (searchListA(aID) == null) {
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");
        } else {
            searchListA(aID).addRecords(recordIn);
            System.out.println(searchListA(aID).getName() + ": Record updated");

        }


    }

    public String getRecords(int ID) throws AnimalNotFound {
        int i = searchList(ID);
        if(i != -1){
            return animalList.get(i).getRecords();
        }
        else{
            throw new AnimalNotFound("**Animal ID is invalid, this animal is not in the system**");
    }}

    public String getList() {
        String stringAns = "Name \t ID\n";
        for(int i=0; i < animalList.size(); i++) {
            stringAns += animalList.get(i).getName() +"\t" + animalList.get(i).getId() + "\n";
            //System.out.println(needs.get(i)+"\n");
        }
        return stringAns;
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