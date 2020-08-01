package com.test.movieinfo.feign;

import com.test.movieinfo.models.Rating;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-api-gateway")
//@RibbonClient(name = "movie-ratings")
@RequestMapping("/movie-ratings/ratings")
public interface MovieRatingFeignService {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") long movieId);





}
