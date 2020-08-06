package com.test.microservicefilm.resources;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.microservicefilm.models.CatalogItem;
import com.test.microservicefilm.services.MovieInfoService;
import com.test.microservicefilm.services.UserRatingInfoService;
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
public class MovieCatalogController {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private UserRatingInfoService userRatingInfoService;


    @RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON)
    @HystrixCommand(fallbackMethod = "getFallbackList")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return userRatingInfoService.getUserRating(userId).getUserRatings()
            .stream().map(rating -> movieInfoService.getCatalogItem(rating))
            .collect(Collectors.toList());
    }

    public List<CatalogItem> getFallbackList(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("default", "default", 23.3)
        );
    }



}
