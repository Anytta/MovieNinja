package servlets;

import Security.MD5;
import dao.UsersDAO;
import dao.UsersDAOImpl;
import model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @EJB
    UsersDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String role = req.getParameter("role");

        System.out.println("Register with password: " + password);

        String passwordMD5  = MD5.hash(password);
        System.out.println("Register with hash: " + passwordMD5);

        // sprawdzenie czy istnieje użytkownik o danym loginie

        User userByLogin = userDAO.getUserByLogin(login);

        if(userByLogin == null){
            User newUser = new User(login, passwordMD5, firstName, lastName, role);

            userDAO.createUsers(newUser);

            resp.sendRedirect(resp.encodeRedirectURL("login.jsp"));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("register.jsp?invalid"));
        }



    }


}

