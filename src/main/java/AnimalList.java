import java.util.ArrayList;
import java.util.List;

public class AnimalList {
    int animalCount;
    List<Animal> animalList;


    public AnimalList(){
        this.animalCount = 0;
        this.animalList = new ArrayList<>();

    }

    public void addAnimal(String nameIn, String speciesIn){
        Animal temp = new Animal(nameIn,speciesIn);
        this.animalList.add(temp);
        this.animalCount += 1;

    }

    public int getCount(){return animalCount;}

    public void removeAnimal(String nameIn) throws EmptyListException {
        if(animalCount<= 0){
            throw new EmptyListException("No animals in list");
        }
        else if(searchList(nameIn) == -1){
            throw new IllegalArgumentException("No animal by that name");
        }
        else{
            animalCount -= 1;
            animalList.remove(searchList(nameIn));

        }

    }


    public int searchList(String nameIn){
        for(int i = 0; i < animalList.size();i++){
            if(animalList.get(i).getName().compareTo(nameIn) == 0 ){
                return i;
            }
        }
        return -1;
    }

}
