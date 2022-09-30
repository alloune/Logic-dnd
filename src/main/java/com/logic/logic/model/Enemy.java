package com.logic.logic.model;


public class Enemy {

    private int id;
    private String name;
    private int hp;
    private String type;
    private int position;
    private int attack;

    private int playerId;


    public Enemy() {
    }

    public Enemy(int id, String name, String type, int hp, int position, int attack) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.position = position;
        this.attack = attack;
    }
    public Enemy(String name, String type, int hp, int position, int attack, int playerId) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.position = position;
        this.attack = attack;
        this.playerId = playerId;
    }

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAttack(int attack) {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int player_id) {
        this.playerId = player_id;
    }


}
