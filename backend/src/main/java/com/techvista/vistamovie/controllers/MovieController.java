package com.techvista.vistamovie.controllers;

import com.techvista.vistamovie.dto.MovieDTO;
import com.techvista.vistamovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
        Page<MovieDTO> result = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO movie = service.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movie);
    }

//    @GetMapping(value = "/search")
//    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
//        MovieDTO movie = service.findById(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movie);
//    }
}
