package AnimalShelter;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {
    int animalCount;
    List<Animal> animalList;


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

}