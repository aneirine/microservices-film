package com.test.movieratings.services;

import com.test.movieratings.models.Rating;
import com.test.movieratings.models.UserRating;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRatingService {

    public UserRating getUserRating(long userId) {
        UserRating userRating = new UserRating(userId, Arrays.asList(
                new Rating(1, 5.6),
                new Rating(2, 7.8)
        ));
        return userRating;
    }
}
