package com.test.microservicefilm.resources;

import com.test.microservicefilm.models.CatalogItem;
import com.test.microservicefilm.models.Movie;
import com.test.microservicefilm.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating(1, 5.6),
                new Rating(2, 7.8)
        );

        return ratings.stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "test desc", rating.getRating());
                }
        ).collect(Collectors.toList());

    }
}
