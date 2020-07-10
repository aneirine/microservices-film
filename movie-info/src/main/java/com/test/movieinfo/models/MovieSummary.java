package com.test.movieinfo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSummary {

    private String original_language;

    private String imdb_id;

    private String video;

    private String title;

    private String backdrop_path;

    private String revenue;

    private String popularity;

    private String id;

    private String vote_count;

    private String budget;

    private String overview;

    private String original_title;

    private String runtime;

    private String poster_path;

    private String release_date;

    private String vote_average;

    private String tagline;

    private String adult;

    private String homepage;

    private String status;
}
