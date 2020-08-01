package com.test.movieratings.models;

import lombok.*;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private long movieId;
    private double rating;


}
