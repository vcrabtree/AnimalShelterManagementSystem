import AnimalList;

    public Manager( String idM,  String passwordM){
        id = idM;
        password = passwordM;

    }



    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
  
    public int checkStatus(int id) {
        Animal animalToCheck;
        animalToCheck = al1.searchList(id);
        return animalToCheck.getStatus();
    }

    public String getNeeds(int id){
        Animal animalToCheck;
        animalToCheck = al1.searchList(id);
        return animalToCheck.getNeeds();
    }

}
