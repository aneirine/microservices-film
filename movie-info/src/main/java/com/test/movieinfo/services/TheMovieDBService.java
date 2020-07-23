package com.test.movieinfo.services;

import com.test.movieinfo.models.Movie;
import com.test.movieinfo.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class TheMovieDBService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;


    public Movie getMovieInfoFromDb(long movieId) {
        MovieSummary summary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" + apiKey,
                MovieSummary.class
        );
        return new Movie(movieId, summary.getTitle(), summary.getOverview());
    }
}
