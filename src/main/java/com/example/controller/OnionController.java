package com.example.controller;

import com.example.model.Onion;
import com.example.repo.OnionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/onions")
public class OnionController {

    private OnionRepo repository;

    @Autowired
    public OnionController(OnionRepo repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Onion> get(@PathVariable("id") Long id) {
        Onion onion = repository.findOne(id);
        if (null == onion) {
            return new ResponseEntity<Onion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Onion>(onion, HttpStatus.OK);
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Onion> update(@RequestBody Onion onion) {
        repository.save(onion);
        return get(onion.getId());
    }

    @RequestMapping
    public List<Onion> all() {
        return repository.findAll();
    }
 }
