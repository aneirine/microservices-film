package com.test.microservicefilm.resources;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.microservicefilm.models.CatalogItem;
import com.test.microservicefilm.models.Movie;
import com.test.microservicefilm.models.Rating;
import com.test.microservicefilm.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON)
    @HystrixCommand(fallbackMethod = "throwDefaultList")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return getUserRating(userId).getUserRatings().stream().map(rating -> getCatalogItem(rating)).collect(Collectors.toList());
    }


    private CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), "test desc", rating.getRating());
    }


    private UserRating getUserRating(String userId) {
        return webClientBuilder.build()
                .get().uri("http://movie-ratings-service/ratings/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
    }

    public List<CatalogItem> throwDefaultList(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("default", "default", 23.3)
        );
    }


}
