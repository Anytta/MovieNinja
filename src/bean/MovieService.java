package bean;

import Security.MD5;
import dao.MovieRentalDAOImpl;
import dao.MoviesDAO;
import dao.UsersDAO;
import model.Movie;
import model.MovieRental;
import model.User;
import view.DTO.MovieDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class MovieService {

    private final List<String> AVAILABLE_GENRES = Arrays.asList("comedy", "drama", "fantasy");

    @EJB
    private MoviesDAO moviesDAO;

    @EJB
    private MovieRentalDAOImpl movieRentalDao;

    public boolean createMovieService(Movie movie) {

           if(movie.getTitle() == null
                    || movie.getTitle().length() <3
                    || movie.getTitle().length() > 255){
                return false;
            }

            if(! AVAILABLE_GENRES.contains(movie.getGenre())){
                return false;
            }

            if(movie.getYear() != null && movie.getYear() <=0){
                return false;
            }

            moviesDAO.createMovie(movie);
            return true;

    }

    public List<MovieDTO> getAllMoviesDtos(String login){

       List<Movie> movies = moviesDAO.getAllMovies();

        List<MovieDTO> moviesDTO = new ArrayList<>();

        for(Movie movie: movies ){

            MovieRental rental = movieRentalDao.getById(login, movie.getId());
            boolean isRented = false;

            if (rental != null) {
                isRented = true;
            }

            moviesDTO.add(new MovieDTO(movie.getId(), movie.getTitle(),
                    movie.getYear(), movie.getGenre(), movie.getDescription(), isRented));

        }

        return moviesDTO;
    }

}

