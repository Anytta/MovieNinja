package view;

import dao.UsersDAO;
import dao.UsersDAOImpl;
import model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/usersList")
public class UserListServlet extends HttpServlet {

    @EJB
    private UsersDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> allUsers = userDAO.getAllUsers();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("users.jsp");
        req.setAttribute("users", allUsers);
        requestDispatcher.forward(req, resp);
    }


}
