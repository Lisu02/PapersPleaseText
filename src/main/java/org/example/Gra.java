package org.example;

public class Gra {

    private Menu menu;
    private Handler handler;
    private Petent[] petenci;
    private int nextPetent=-1;

    public Gra(Menu menu,Handler handler){
        this.menu = menu;
        this.handler = handler;
    }

    public Petent petentInfo(){
        nextPetent += 1;
        return petenci[nextPetent];
    }
}
