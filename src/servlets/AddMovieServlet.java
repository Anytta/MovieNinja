package servlets;

import Security.MD5;
import bean.MovieService;
import dao.MoviesDAO;
import dao.MoviesDaoImpl;
import dao.UsersDAO;
import dao.UsersDAOImpl;
import model.Movie;
import model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/addMovie")
public class AddMovieServlet extends HttpServlet {

   @EJB
    MovieService movieService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");



        try {
            int year = Integer.parseInt(req.getParameter("year"));
            Movie newMovie = new Movie(null, title, year, genre, description);

            boolean success = movieService.createMovieService(newMovie);
            if (success) {
                resp.sendRedirect(resp.encodeRedirectURL("moviesList"));
            } else {
                resp.sendRedirect(resp.encodeRedirectURL("enterMovie.jsp?invalid"));
            }
        }
            catch (NumberFormatException e){
                resp.sendRedirect(resp.encodeRedirectURL("enterMovie.jsp?invalid"));
            }
            }
}

