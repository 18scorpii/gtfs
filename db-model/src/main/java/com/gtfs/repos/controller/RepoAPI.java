package com.gtfs.repos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("/api")
@RestController
public class RepoAPI {
    @Autowired
    RouteRepo routeRepo;

    @GetMapping("/{repo}")
    public ResponseEntity getName(@PathVariable("repo") String repo){
        if(repo.equalsIgnoreCase("routes"))
            return new ResponseEntity(routeRepo.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity("Unrecognized Repo Name", HttpStatus.BAD_REQUEST);
    }
}
