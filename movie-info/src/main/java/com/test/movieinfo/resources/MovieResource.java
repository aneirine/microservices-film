package com.test.movieinfo.resources;

import com.test.movieinfo.services.MovieService;
import com.test.movieinfo.services.TheMovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private TheMovieDBService movieDBService;

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/moviedb/{movieId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getMovieInfoFromDb(@PathVariable("movieId") long movieId) {
        return new ResponseEntity(movieDBService.getMovieInfoFromDb(movieId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getMovieInfo(@PathVariable("movieId") long movieId) {
        return new ResponseEntity(movieService.getMovieInfo(movieId), HttpStatus.OK);
    }

    @GetMapping(value = "/ratings/movie/{movieId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getMovieInfoWithRating(@PathVariable("movieId") long movieId){
        return new ResponseEntity(movieService.getMovieInfoWithRatings(movieId), HttpStatus.OK);
    }
}
