package com.example.controller;

import com.example.model.Opinion;
import com.example.repo.OpinionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/opinions")
public class OpinionController {

    private OpinionRepo repository;


    @Autowired
    public OpinionController(OpinionRepo repository){
        this.repository = repository;
        
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Opinion> get(@PathVariable("id") Long id) {
        Opinion opinion = repository.findOne(id);
        if (null == opinion) {
            return new ResponseEntity<Opinion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Opinion>(opinion, HttpStatus.OK);
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Opinion> update(@RequestBody Opinion opinion) {
        repository.save(opinion);
        return get(opinion.getId());
    }

    @RequestMapping
    public List<Opinion> all() {
        return repository.findAll();
    }
 }
