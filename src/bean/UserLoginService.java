package bean;

import Security.MD5;
import dao.UsersDAO;
import model.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

@Stateless
public class UserLoginService {

    @EJB
    UsersDAO userDAO;

    public boolean loginToApplication(String username, String password, HttpSession httpSession) {

        String passwordMD5 = MD5.hash(password);
        User userByLogin = userDAO.getUserByLogin(username);

        if (userByLogin != null && userByLogin.getPassword().equals(passwordMD5)) {
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("role", userByLogin.getRole());
           return true;

        } else {
            return false;
        }
    }
}

