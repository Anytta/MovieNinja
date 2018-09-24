package servlets;

import dao.MoviesDAO;
import dao.MoviesDaoImpl;
import model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {

    MoviesDAO movieDAO = new MoviesDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = parseInt(req.getParameter("id"));

        movieDAO.deleteMovie(id);

       resp.sendRedirect(resp.encodeRedirectURL("moviesList"));


    }


}

