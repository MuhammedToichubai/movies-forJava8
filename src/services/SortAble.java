package services;

import classes.Movie;

import java.util.List;

public interface SortAble {

    void sortByMovieName(List<Movie> movies);

    void sortByYear(List<Movie> movies);

    void sortByDirectorName(List<Movie> movies);

}
