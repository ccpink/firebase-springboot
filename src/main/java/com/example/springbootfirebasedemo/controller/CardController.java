package com.example.springbootfirebasedemo.controller;

import com.example.springbootfirebasedemo.entity.Card;
import com.example.springbootfirebasedemo.entity.Monster;
import com.example.springbootfirebasedemo.service.CardService;
import com.example.springbootfirebasedemo.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CardService cardService;


    @PostMapping("/cards")
    public String saveCard(@RequestBody Card card) throws ExecutionException, InterruptedException {
        return cardService.saveCard(card);
    }

    @GetMapping("/cards")
    public List<Card> getCards() throws ExecutionException, InterruptedException {
        return cardService.getCards();
    }


}
