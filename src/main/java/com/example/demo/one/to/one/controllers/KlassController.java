package com.example.demo.one.to.one.controllers;

import com.example.demo.one.to.one.entities.Klass;
import com.example.demo.one.to.one.entities.Leader;
import com.example.demo.one.to.one.repositories.KlassRepositories;
import com.example.demo.one.to.one.repositories.LeaderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/klasses")
public class KlassController {
    @Autowired
    private KlassRepositories klassRepositories;

    @Autowired
    private LeaderRepositories leaderRepositories;

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass add(@RequestBody Klass klass){
       return klassRepositories.save(klass);
    }

    @Transactional
    @PutMapping(path = "/{klass_id}")
    public ResponseEntity addLeaderToClass(@PathVariable long id, @RequestBody Klass klass){
        Leader leader = leaderRepositories.findById(id).get();
        leader.setKlass(klass);
        klassRepositories.save(klass);
        leaderRepositories.save(leader);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
