package view;


import bean.MovieRentalService;
import model.Movie;
import view.DTO.MovieDTO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myRentals")
public class UserMoviesListServlet extends HttpServlet {

    @EJB
    private MovieRentalService movieRentalService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");

        List<Movie> allMovies = movieRentalService.getUserMovies(username);

        List<MovieDTO> movieDtos = new ArrayList<>();

        for (Movie movie: allMovies) {
            movieDtos.add(new MovieDTO (movie.getId(), movie.getTitle(),
                    movie.getYear(), movie.getGenre(), movie.getDescription(), true));
        }

        req.setAttribute("title", "My movies");
        req.setAttribute("movies", movieDtos);

        req.getRequestDispatcher("myRentals.jsp").forward(req, resp);
    }
}
