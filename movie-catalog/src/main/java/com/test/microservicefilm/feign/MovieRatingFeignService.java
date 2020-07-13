package com.test.microservicefilm.feign;

import com.test.microservicefilm.models.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "movie-ratings-service")
public interface MovieRatingFeignService {

    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") long userId) ;
}
