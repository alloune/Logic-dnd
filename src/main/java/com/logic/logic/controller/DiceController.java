package com.logic.logic.controller;

import com.logic.logic.model.Enemy;
import com.logic.logic.model.Hero;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@SpringBootApplication
@RestController
public class DiceController {


    String BASE_URL = "http://localhost:8080/characters/";
    String BASE_ENEMY_URL = "http://localhost:8080/enemies/";
    @GetMapping(value = "/start-round/{id}")
    public RedirectView resolveGame(@PathVariable int id) {
        RestTemplate heroTemplate = new RestTemplate();
        int move = rollTheDice();

        Hero heroToMove = heroTemplate.getForObject(BASE_URL + id, Hero.class);
        heroToMove.setPosition(heroToMove.getPosition() + move);

        heroTemplate.put(BASE_URL + id, heroToMove);

        if(heroToMove.getPosition() >= 64){
            return new RedirectView("http://localhost:8083/youWin");
        }
        if(heroToMove.getHp() <= 0){
            return new RedirectView("http://localhost:8083/youLost");
        }

        return new RedirectView("http://localhost:8083/playgame/"+id);

    }

    public int rollTheDice() {

        Random random = new Random();
        return random.nextInt(6) + 1;

    }
    @GetMapping(value = "/generate/{id}")
    public RedirectView generateEnemies(@PathVariable int id){
        Enemy[] newEnemies = new Enemy[4];
        newEnemies[0] = new Enemy("Charlène", "Sorcière", 5,7,4, id);
        newEnemies[1] = new Enemy("Bahjat", "Gredin", 8,13,2, id);
        newEnemies[2] = new Enemy("Loris", "Voleur", 4,24,6, id);
        newEnemies[3] = new Enemy("Allan", "Barbare", 6,36,3, id);
        RestTemplate enemyTemplate = new RestTemplate();
        Enemy[] listOfEnemy= enemyTemplate.getForObject(BASE_ENEMY_URL+id, Enemy[].class);


        if(listOfEnemy.length > 0){

            return new RedirectView("http://localhost:8083/playgame/"+id);

        }

        for (Enemy enemy: newEnemies) {
            enemyTemplate.postForObject("http://localhost:8080/enemies/", enemy, Enemy.class);
        }


        return new RedirectView("http://localhost:8083/playgame/"+id);
    }

}
