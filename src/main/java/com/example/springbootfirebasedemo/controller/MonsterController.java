package com.example.springbootfirebasedemo.controller;

import com.example.springbootfirebasedemo.entity.Monster;
import com.example.springbootfirebasedemo.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @PostMapping("/monsters")
    public String saveMonster(@RequestBody Monster monster) throws ExecutionException, InterruptedException {
        return monsterService.saveMonster(monster);
    }

    @GetMapping("/monsters")
    public List<Monster> getMonsters() throws ExecutionException, InterruptedException {
        return monsterService.getMonsters();
    }
}
