package com.techvista.vistamovie.repositories;

import com.techvista.vistamovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
