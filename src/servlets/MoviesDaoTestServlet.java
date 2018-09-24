package servlets;

import dao.MoviesDAO;
import dao.MoviesDaoImpl;
import model.Movie;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/moviesDaoTest")
public class MoviesDaoTestServlet extends HttpServlet {

    MoviesDAO moviesDao = new MoviesDaoImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        moviesDao.createMovie(new Movie( "Teoria wszystkiego", 2009, "biograficzny", "Film biograficzny...."));
        resp.getWriter().write(moviesDao.toString());

//        List<Movie> all = moviesDao.getAllMovies();
//        for (Movie movie: all) {
//            resp.getWriter().write(movie + "<br/>");
//        }
    }

}
