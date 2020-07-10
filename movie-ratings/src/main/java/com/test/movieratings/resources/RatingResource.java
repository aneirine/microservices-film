package com.test.movieratings.resources;

import com.test.movieratings.models.Rating;
import com.test.movieratings.models.UserRating;
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
    public UserRating getUserRatings(@PathVariable("userId") long userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating(1, 5.6),
                new Rating(2, 7.8)
        );

        UserRating userRating = new UserRating(ratings);
        return userRating;
    }
}
