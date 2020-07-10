package com.test.microservicefilm.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserRating {

    private List<Rating> userRatings;


}
