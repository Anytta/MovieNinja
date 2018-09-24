package servlets;
//sprawdzone
import bean.MovieRentalService;
import model.MovieRental;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rentals")
public class RentalListServlet extends HttpServlet {

    @EJB
    private MovieRentalService movieRentalService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MovieRental> allRentedMovies = movieRentalService.getAll();
        req.setAttribute("rentals", allRentedMovies);

        req.getRequestDispatcher("rentals.jsp").forward(req, resp);


    }
}