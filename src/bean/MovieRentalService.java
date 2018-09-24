package bean;

import dao.MovieRentalDAOImpl;
import dao.MoviesDAO;
import dao.MoviesDaoImpl;
import dao.UsersDAO;
import model.Movie;
import model.MovieRental;
import model.User;
import view.DTO.MovieDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovieRentalService {

    @EJB
    private MovieRentalDAOImpl movieRentalDao;

    @EJB
    private MoviesDAO moviesDao;

    @EJB
    private UsersDAO userDao;

    public List<MovieRental> getAll() {
        return movieRentalDao.getAllMovieRentals();
    }

     public List<Movie> getUserMovies(String login){

        List <MovieRental> userMoviesRentals = movieRentalDao.getUserMovies(login);

        List<Movie> movies = new ArrayList<>();

        for (MovieRental userMovieRental: userMoviesRentals) {
            Movie movie = moviesDao.getMovieById(userMovieRental.getMovieId());
            movies.add(movie);
        }

        return movies;
    }

    public boolean returnMovie(MovieRental movieToRent) {

        //czy jest taki uzytkownik
        User userByLogin = userDao.getUserByLogin(movieToRent.getLogin());
        if(userByLogin == null){
            return false;
        }

        //czy jest taki film
        Movie movieById = moviesDao.getMovieById(movieToRent.getMovieId());
        if(movieById == null){
            return false;
        }

        //czy ten film jest juz pozyczony przez tego uzytkownika
        MovieRental movieRentalById = movieRentalDao.getById(movieToRent.getLogin(), movieToRent.getMovieId());
        if(movieRentalById == null){
            return false;
        }
        movieRentalDao.createReturn(movieToRent);
        return true;

    }



    public boolean rent(MovieRental movieToRent){

        //czy jest taki uzytkownik
        User userByLogin = userDao.getUserByLogin(movieToRent.getLogin());
        if(userByLogin == null){
            return false;
        }

        //czy jest taki film
        Movie movieById = moviesDao.getMovieById(movieToRent.getMovieId());
        if(movieById == null){
            return false;
        }

        //czy ten film jest juz pozyczony przez tego uzytkownika
        MovieRental movieRentalById = movieRentalDao.getById(movieToRent.getLogin(), movieToRent.getMovieId());
        if(movieRentalById != null){
            return false;
        }

        movieRentalDao.createRental(movieToRent);
        return true;

    }


}
