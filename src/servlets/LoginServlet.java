package servlets;

import bean.UserLoginService;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private UserLoginService userLoginBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("username");
        String password = req.getParameter("password");

//        System.out.println("Password: " + password);
//        System.out.println("Password MD5: " + passwordMD5);


        if (userLoginBean.loginToApplication(login, password, req.getSession())) {
            resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login.jsp?invalid"));
        }


    }
}
//
//        // tradycyjnie
//        List<User> users = UserServlet.users;
//
//        boolean loginDataCorrect = false;
//        for (User user : users) {
//            if(user.getLogin().equals(userName) && user.getPassword().equals(password)){
//                loginDataCorrect = true;
//                break;
//            }
//        }
//
//        // JAVA 8
////        boolean loginDataCorrect = UsersServlet.users.stream()
////                .anyMatch(u -> u.getLogin().equals(login) && u.getPassword().equals(password));
//
//
//        if(loginDataCorrect){
//            HttpSession session = req.getSession();
//            session.setAttribute("username", userName);
//            resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
//        } else {
//            resp.sendRedirect(resp.encodeRedirectURL("login.jsp?invalid"));
//        }
//
//
//    }

