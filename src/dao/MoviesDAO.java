package dao;

import model.Movie;

import java.util.List;


public interface MoviesDAO {

    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    List<Movie> getMovieByGenre(String genre);

    List<String> getAllGenres();

    void createMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(int id);

}
