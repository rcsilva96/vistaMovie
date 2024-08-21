package com.techvista.vistamovie.controllers;

import com.techvista.vistamovie.dto.MovieDTO;
import com.techvista.vistamovie.dto.ScoreDTO;
import com.techvista.vistamovie.services.MovieService;
import com.techvista.vistamovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping()
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO = service.saveScore(dto);
        return movieDTO;
    }

}

