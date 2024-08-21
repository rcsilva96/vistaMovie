package com.techvista.vistamovie.services;

import com.techvista.vistamovie.dto.MovieDTO;
import com.techvista.vistamovie.entities.Movie;
import com.techvista.vistamovie.entities.User;
import com.techvista.vistamovie.repositories.MovieRepository;
import com.techvista.vistamovie.repositories.ScoreRepository;
import com.techvista.vistamovie.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techvista.vistamovie.dto.ScoreDTO;
import com.techvista.vistamovie.entities.Score;

@Service
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    public ScoreService(MovieRepository movieRepository, ScoreRepository scoreRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);

    }
}
