package com.example.mymovie.repository;

import com.example.mymovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
