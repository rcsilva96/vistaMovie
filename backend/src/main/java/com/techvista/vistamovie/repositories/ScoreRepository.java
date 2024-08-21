package com.techvista.vistamovie.repositories;

import com.techvista.vistamovie.entities.Score;
import com.techvista.vistamovie.entities.ScorePK;
import com.techvista.vistamovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
