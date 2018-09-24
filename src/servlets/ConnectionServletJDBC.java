package servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/connection")
public class ConnectionServletJDBC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {
            String url = "jdbc:mysql://localhost:3306/JDBCtest?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(url, username, password);
            PrintWriter writer = resp.getWriter();
            writer.write("Connected");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
