package com.test.movieratings.models;

public class Rating {

    private long movieId;
    private double rating;

    public Rating(long movieId, double rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
