package servlets;

import bean.MovieRentalService;
import model.MovieRental;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/return")
public class ReturnMovieServlet extends HttpServlet {

    @EJB
    private MovieRentalService movieRentalService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int movieId = Integer.parseInt(req.getParameter("movieId"));
        String login = (String) req.getSession().getAttribute("username");

        boolean rented = movieRentalService.returnMovie(new MovieRental(login, movieId));

        if(rented){
            resp.sendRedirect(resp.encodeRedirectURL("myRentals"));

        } else {
            //resp.sendRedirect(resp.encodeRedirectURL("error.jsp"));

            PrintWriter writer = resp.getWriter();
            writer.write("error");
            writer.write(String.valueOf(rented));
        }


    }
}
