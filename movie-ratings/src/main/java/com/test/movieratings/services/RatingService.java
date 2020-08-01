package com.test.movieratings.services;

import com.test.movieratings.models.Rating;
import org.springframework.stereotype.Service;

@Service
public class RatingService {


    public Rating getRating(long movieId){
        return new Rating(movieId, 1.2);
    }
}
