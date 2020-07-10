package com.test.movieinfo.resources;

import com.test.movieinfo.models.Movie;
import com.test.movieinfo.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/moviedb/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Movie getMovieInfoFromDb(@PathVariable("movieId") long movieId) {
        MovieSummary summary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" + apiKey,
                MovieSummary.class
        );
        return new Movie(movieId, summary.getTitle(), summary.getOverview());
    }

    @RequestMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Movie getMovieInfo(@PathVariable("movieId") long movieId) {
        return new Movie(movieId, "Test title", "Test descrpition");
    }
}
