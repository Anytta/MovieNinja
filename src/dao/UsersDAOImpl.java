package dao;

import model.User;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersDAOImpl implements UsersDAO {

    private Connection connection;


    public UsersDAOImpl() {

        try {
            String url = "jdbc:mysql://localhost:3306/movies_ninja?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // wypisuje wszystkich userów z bazy GET
    @Override
    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String role = resultSet.getString("role");

                User newUser = new User(login, password, firstName, lastName, role);
                usersList.add(newUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    //wypisuje danego usera po loginie
    @Override
    public User getUserByLogin(String login) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login=?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String role = resultSet.getString("role");

                return new User(login, password, firstName, lastName, role);

            }

            preparedStatement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //tworzy nowego usera w bazie danych POST
    @Override
    public void createUsers(User user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,'user');");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // aktualizuje dane o userze w bazie danych PUT
    @Override
    public void updateUser(User user) {

        try {

            PreparedStatement preparedStatement
                    = connection.prepareStatement("UPDATE users SET firstName = ?, lastName = ?, password = ? WHERE login = ?;");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLogin());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // usuwa usera z bazy DELETE
    @Override
    public void deleteUser(String login) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE login = ?;");
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}