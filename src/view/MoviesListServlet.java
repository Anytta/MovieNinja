package view;

import bean.MovieService;
import view.DTO.MovieDTO;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/moviesList")
public class MoviesListServlet extends HttpServlet {

    @EJB
    private MovieService movieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getSession().getAttribute("username");
        List<MovieDTO> allMoviesList = movieService.getAllMoviesDtos(login);
        //albo List <MoviesDto>

        req.setAttribute("title", "Lista wszystkich filmów");
        req.setAttribute("movies", allMoviesList);

        req.getRequestDispatcher("moviesList.jsp").forward(req, resp);


    }







    /*
        Zwraca (w postaci tekstu) dane wszystkich użytkowników
        (zwraca wszystkich użytkowników z listy zamienionych na Stringa)
     */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        PrintWriter writer = resp.getWriter();
//
//        for (User user : users) {
//            writer.write(user.toString());
//        }
//    }
//
//    /*
//        Tworzy nowego użytkownika - dodaje do listy users
//        Parametry: login,password,firstName,lastName (dane użytkownika do stworzenia)
//     */
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String login = req.getParameter("login");
//        String password = MD5.hash(req.getParameter("password"));
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//
//
//        // sprawdzenie czy istnieje użytkownik o danym loginie
//        boolean userWithLoginExists = users.stream().anyMatch(u -> u.getLogin().equals(login));
//
//
//        if (!userWithLoginExists) {
//            User newUser = new User(login, password, firstName, lastName);
//            users.add(newUser);
//            resp.getWriter().write("User creted!");
//        } else {
//            resp.getWriter().write("User already exists with login " + login);
//        }
//
//    }
//
//    /*
//        Aktualizuje dane istniejącego użytkownika
//        Parametry: login,password,firstName,lastName (login - do znalezienia użytkownika,
//        reszta - dane do aktualizacji)
//     */
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String login = req.getParameter("login");
//        String password = MD5.hash(req.getParameter("password"));
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//
//        for (User user : users) {
//            if (user.getLogin().equals(login)) {
//                user.setFirstName(firstName);
//                user.setLastName(lastName);
//                user.setPassword(password);
//
//                resp.getWriter().write("User updated!");
//                return;
//            }
//        }
//
//        resp.getWriter().write("User with login " + login + " does not exist!");
//    }
//
//    /*
//        Usuwa użytkownika o podanym loginie
//        Parametry: login (login użytkownika do usunięcia)
//     */
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String login = req.getParameter("login");
//
//        for (User user : users) {
//            if(user.getLogin().equals(login)){
//                users.remove(user);
//                resp.getWriter().write("User has been deleted!");
//                return;
//            }
//        }
//
//        resp.getWriter().write("User with login " + login + " does not exist!");
//    }


}

