package com.test.movieinfo.resources;

import com.test.movieinfo.models.Movie;
import com.test.movieinfo.services.TheMovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private TheMovieDBService movieDBService;

    @RequestMapping(value = "/moviedb/{movieId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getMovieInfoFromDb(@PathVariable("movieId") long movieId) {
        return new ResponseEntity(movieDBService.getMovieInfoFromDb(movieId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Movie getMovieInfo(@PathVariable("movieId") long movieId) {
        return new Movie(movieId, "Test title", "Test descrpition");
    }
}
