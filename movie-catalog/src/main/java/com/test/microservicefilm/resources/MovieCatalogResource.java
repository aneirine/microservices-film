package com.test.microservicefilm.resources;


import com.test.microservicefilm.models.CatalogItem;
import com.test.microservicefilm.models.Movie;
import com.test.microservicefilm.models.Rating;
import com.test.microservicefilm.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private MovieRatingFeignService ratingFeignService;


    @Autowired
    private MovieInfoFeignService infoFeignService;


    @RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON)
    //   @HystrixCommand(fallbackMethod = "throwDefaultList")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return getUserRating(userId).getUserRatings().stream().map(rating -> getCatalogItem(rating)).collect(Collectors.toList());
    }


    private CatalogItem getCatalogItem(Rating rating) {
        Movie movie = infoFeignService.getMovieInfo(rating.getMovieId());
        return new CatalogItem(movie.getName(), "test desc", rating.getRating());
    }


    private UserRating getUserRating(String userId) {
        return ratingFeignService.getUserRatings(Long.valueOf(userId));
    }

    public List<CatalogItem> throwDefaultList(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("default", "default", 23.3)
        );
    }


}
