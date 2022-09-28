package com.logic.logic.model;

public class Hero {

    //attributs de la classe
    private int id;
    private String name ;
    private int hp;
    private String type;
    private int position;


    //constructeur
    public Hero() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Hero(String name, String type){
        this.name = name;
        this.type = type;
    }
    public Hero(int id, String name, String type, int hp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
    }
    //Getters - Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}


