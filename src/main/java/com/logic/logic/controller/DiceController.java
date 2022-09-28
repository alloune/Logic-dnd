package com.logic.logic.controller;

import com.logic.logic.model.Hero;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@RestController
public class DiceController {

    String BASE_URL = "http://localhost:8080/characters/";
    @GetMapping(value = "/start-round/{id}")
    public void resolveGame(@PathVariable int id) {
        RestTemplate heroTemplate = new RestTemplate();
        int move = rollTheDice();

        Hero heroToMove = heroTemplate.getForObject(BASE_URL + id, Hero.class);
        heroToMove.setPosition(heroToMove.getPosition() + move);

        heroTemplate.put(BASE_URL + id, heroToMove);

    }

    public int rollTheDice() {

        Random random = new Random();
        return random.nextInt(6) + 1;

    }


}
