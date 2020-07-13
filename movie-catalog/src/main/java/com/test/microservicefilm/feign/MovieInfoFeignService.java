package com.test.microservicefilm.feign;

import com.test.microservicefilm.models.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.MediaType;

@FeignClient(name = "movie-info-service")
public interface MovieInfoFeignService {

    @RequestMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON)
    public Movie getMovieInfo(@PathVariable("movieId") long movieId);
}
