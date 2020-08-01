package com.test.movieratings.api;

import com.test.movieratings.services.RatingService;
import com.test.movieratings.services.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private UserRatingService userRatingService;

    @Autowired
    private RatingService ratingService;

    @GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getRating(@PathVariable("movieId") long movieId) {
        return new ResponseEntity(ratingService.getRating(movieId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUserRatings(@PathVariable("userId") long userId) {
        return new ResponseEntity(userRatingService.getUserRating(userId), HttpStatus.OK);
    }


}
