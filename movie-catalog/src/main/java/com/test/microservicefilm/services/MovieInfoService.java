package com.test.microservicefilm.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.microservicefilm.models.CatalogItem;
import com.test.microservicefilm.models.Movie;
import com.test.microservicefilm.models.Rating;
import com.test.microservicefilm.feign.MovieInfoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoService {

    @Autowired
    private MovieInfoFeignService infoFeignService;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = infoFeignService.getMovieInfo(rating.getMovieId());
        return new CatalogItem(movie.getName(), "test desc", rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating){
        return new CatalogItem("Fallback catalock item", "fallback catalog description", 0.0);
    }

}
