package com.techvista.vistamovie.repositories;

import com.techvista.vistamovie.entities.Movie;
import com.techvista.vistamovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
