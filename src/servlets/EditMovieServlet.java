package servlets;

import dao.MoviesDAO;
import dao.MoviesDaoImpl;
import model.Movie;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;


@WebServlet("/editMovie")
public class EditMovieServlet extends HttpServlet {

    @EJB
    private MoviesDAO moviesDao;

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id = Integer.parseInt(req.getParameter("id"));

            Movie movie = moviesDao.getMovieById(id);

            req.setAttribute("movie", movie);

            req.getRequestDispatcher("editMovie.jsp").forward(req, resp);


        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String year = req.getParameter("year");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");

        Movie movie = new Movie(id,title,parseInt(year),genre,description);
        moviesDao.updateMovie(movie);

        resp.sendRedirect(resp.encodeRedirectURL("moviesList"));


    }


}

