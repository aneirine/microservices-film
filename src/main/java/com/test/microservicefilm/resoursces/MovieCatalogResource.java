package com.test.microservicefilm.resoursces;

import com.test.microservicefilm.models.CatalogItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MovieCatalogResource {

    public List<CatalogItem> getCatalog(String userId){

        return null;
    }
}
