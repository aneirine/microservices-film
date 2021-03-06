package com.test.microservicefilm.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.microservicefilm.models.UserRating;
import com.test.microservicefilm.feign.MovieRatingFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRatingInfoService {

    @Autowired
    private MovieRatingFeignService ratingFeignService;

    @HystrixCommand(fallbackMethod = "getFallbackUserRatings")
    public UserRating getUserRating(String userId) {
        return ratingFeignService.getUserRatings(Long.valueOf(userId));
    }


    public UserRating getFallbackUserRatings(String userId)  {
        return new UserRating(new ArrayList<>());
    }

}
