package com.test.movieinfo.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.test.movieinfo.models.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MovieService {


    @HystrixCommand(fallbackMethod = "getDefaultMovieInfo")
    public Movie getMovieInfo(long movieId) {
        return new Movie(movieId, "Test title", "Test descrpition");
    }

    public Movie getDefaultMovieInfo(long movieId){
        return new Movie(movieId, "Fallback default", "Fallback default");
    }
}
