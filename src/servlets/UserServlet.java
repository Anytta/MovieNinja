package servlets;

//sprawdzono

import Security.MD5;
import dao.UsersDAO;
import model.User;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @EJB
    private UsersDAO userDAO;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




   //     List<User> users = (List<User>) request.getAttribute("users")

        PrintWriter writer = resp.getWriter();

        for (User user : userDAO.getAllUsers()) {
            writer.write(user.toString());
        }
    }

    /*
        Tworzy nowego użytkownika - dodaje do listy users
        Parametry: login,password,firstName,lastName (dane użytkownika do stworzenia)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = MD5.hash(req.getParameter("password"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        //String role = req.getParameter("role");


        String passwordMD5 = MD5.hash(password);

        // sprawdzenie czy istnieje użytkownik o danym loginie
        User userByLogin = userDAO.getUserByLogin(login);


        if (userByLogin == null) {
            User newUser = new User(login, passwordMD5, firstName, lastName);
            userDAO.createUsers(newUser);

            resp.getWriter().write("User created!");
        } else {
            resp.getWriter().write("User already exists with login " + login);
        }

    }

    /*
        Aktualizuje dane istniejącego użytkownika
        Parametry: login,password,firstName,lastName (login - do znalezienia użytkownika,
        reszta - dane do aktualizacji)
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = MD5.hash(req.getParameter("password"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
       // String role = req.getParameter("role");

        password = MD5.hash(password);

        User user = new User(login, password, firstName, lastName);
        userDAO.updateUser(user);

    }

    /*
        Usuwa użytkownika o podanym loginie
        Parametry: login (login użytkownika do usunięcia)
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");

        User userByLogin = userDAO.getUserByLogin(login);
        if (userByLogin != null) {
            userDAO.deleteUser(login);
            resp.getWriter().write("User has been deleted!");
        } else {
            resp.getWriter().write("User with login " + login + " does not exist!");
        }

    }
    }

