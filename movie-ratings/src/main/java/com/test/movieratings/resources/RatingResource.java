package com.test.movieratings.resources;

import com.test.movieratings.models.Rating;
import com.test.movieratings.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Rating getRating(@PathVariable("movieId") long movieId) {
        return new Rating(movieId, 1.2);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") long userId) {
        UserRating userRating = new UserRating(Arrays.asList(
                new Rating(1, 5.6),
                new Rating(2, 7.8)
        ));
        return userRating;
    }
}
