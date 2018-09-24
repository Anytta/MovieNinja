package servlets;

import dao.UsersDAO;
import dao.UsersDAOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userDAOTest")
public class UserDAOTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDAO userDAO = new UsersDAOImpl();
//
//        userDAO.createUsers(new User("admin2","admin","Jan","Kowalski"));
//        userDAO.updateUser(new User("admin2","admin","Anita","Sparzynska"));
//        userDAO.createUsers(new User("user1","user","Jan","Nowak"));
//        userDAO.createUsers(new User("user2","user","Stas","Kowalski"));
//        userDAO.deleteUser("user2");


      //  resp.getWriter().write(user.toString());

        List<User> usersList= userDAO.getAllUsers();

        for (User user: usersList) {
            resp.getWriter().write(user.toString());
        }

    }
}
