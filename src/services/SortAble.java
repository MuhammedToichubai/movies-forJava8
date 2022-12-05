package interfaces;

import classes.Movie;

import java.util.List;

public interface SortAble {

    void sortByMovieName(List<Movie> movies);

    void sortByYear(List<Movie> movies);

    void sortByDirector(List<Movie> movies);

}
