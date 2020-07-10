package com.test.microservicefilm.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {

    private long movieId;
    private double rating;


}
