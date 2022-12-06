package services;

import classes.Movie;

import java.time.Year;
import java.util.List;

public interface FindAble {

    List<Movie> getAllMovies(List<Movie> movies);

    void findMovieByName(List<Movie> movies, String movieName);

    void findMovieByActorName(List<Movie> movies, String actorName);

    void findMovieByYear(List<Movie> movies, Year year);

    void findMovieByDirector(List<Movie> movies, String directorName);

    void findMovieByDescription(List<Movie> movies, String description);

    void findMovieByRole(List<Movie> movies, String role);

}
