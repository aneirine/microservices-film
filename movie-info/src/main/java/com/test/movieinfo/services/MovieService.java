package com.test.movieinfo.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.movieinfo.feign.MovieRatingFeignService;
import com.test.movieinfo.models.Movie;
import com.test.movieinfo.models.MovieWithRatings;
import com.test.movieinfo.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRatingFeignService ratingFeignService;

    @HystrixCommand(fallbackMethod = "getDefaultMovieInfo")
    public Movie getMovieInfo(long movieId) {
        return new Movie(movieId, "Test title", "Test descrpition");
    }

    public Movie getDefaultMovieInfo(long movieId) {
        return new Movie(movieId, "Fallback default", "Fallback default");
    }

    public MovieWithRatings getMovieInfoWithRatings(long movieId) {
        Rating rating = ratingFeignService.getRating(movieId);
        return new MovieWithRatings(movieId, "Random name", rating.getRating());
    }
}
