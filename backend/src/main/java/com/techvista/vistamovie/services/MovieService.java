package com.techvista.vistamovie.services;

import com.techvista.vistamovie.dto.MovieDTO;
import com.techvista.vistamovie.entities.Movie;
import com.techvista.vistamovie.exceptions.EstelionatoException;
import com.techvista.vistamovie.exceptions.ForbiddenIdException;
import com.techvista.vistamovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

//    @Transactional(readOnly = true)
//    public MovieDTO findById(Long id){
//        Movie result = repository.findById(id).get();
//        MovieDTO dto = new MovieDTO(result);
//        return dto;
//    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        if (id == 666L) {
            throw new ForbiddenIdException("Não mexa com as forças das trevas");
        }
        if (id == 171) {
            throw new EstelionatoException("Estelionatários estão proibidos");
        }

        Movie result = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Filme não encontrado! ID: " + id));

        return new MovieDTO(result);
    }



}


