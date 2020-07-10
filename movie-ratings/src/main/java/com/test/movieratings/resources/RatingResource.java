package com.test.movieratings.resources;

import com.test.movieratings.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") long movieId) {
        return new Rating(movieId, 1.2);
    }

    @RequestMapping("/users/{userId}")
    public List<Rating> getUserRatings(@PathVariable("userId") long userId) {
        return Arrays.asList(
                new Rating(1, 5.6),
                new Rating(2, 7.8)
        );
    }
}
