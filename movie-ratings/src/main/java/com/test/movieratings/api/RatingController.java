package com.test.movieratings.api;

import com.test.movieratings.models.Rating;
import com.test.movieratings.models.UserRating;
import com.test.movieratings.services.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private UserRatingService userRatingService;

    @GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Rating getRating(@PathVariable("movieId") long movieId) {
        return new Rating(movieId, 1.2);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUserRatings(@PathVariable("userId") long userId) {
       return new ResponseEntity(userRatingService.getUserRating(userId), HttpStatus.OK);
    }


}
