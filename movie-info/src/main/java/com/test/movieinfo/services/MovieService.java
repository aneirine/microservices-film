package com.test.movieinfo.services;

import com.test.movieinfo.models.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MovieService {

    public Movie getMovieInfo(long movieId) {
        return new Movie(movieId, "Test title", "Test descrpition");
    }
}
