package dao;

import model.MovieRental;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovieRentalDAOImpl {

    private Connection connection;

    public MovieRentalDAOImpl() {
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

    public List<MovieRental> getAllMovieRentals() {
        List<MovieRental> movieRentals = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM movie_rentals;");

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                int movieId = resultSet.getInt("movieId");
                movieRentals.add(new MovieRental(login, movieId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieRentals;
    }


    public List<MovieRental> getUserMovies(String login) {

        List<MovieRental> movieRentals = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movie_rentals WHERE login=?;");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int movieId = resultSet.getInt("movieId");
                movieRentals.add(new MovieRental(login, movieId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieRentals;
    }

    public void createRental(MovieRental movieRental) {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO movie_rentals VALUES (?,?);");
            statement.setString(1, movieRental.getLogin());
            statement.setInt(2, movieRental.getMovieId());
            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createReturn(MovieRental movieRental) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM movie_rentals WHERE login=? AND movieId=?;");
            statement.setString(1, movieRental.getLogin());
            statement.setInt(2, movieRental.getMovieId());
            statement.executeUpdate();
           // ResultSet resultSet = statement.executeQuery();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MovieRental getById(String login, Integer movieId){

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from movie_rentals WHERE login=? AND movieID=?;");
            statement.setString(1, login);
            statement.setInt(2, movieId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new MovieRental(login, movieId);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
