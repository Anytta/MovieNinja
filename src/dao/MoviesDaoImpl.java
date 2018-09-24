package dao;

import model.Movie;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MoviesDaoImpl implements MoviesDAO {

    Connection connection;

    public MoviesDaoImpl() {
        try {

            String url = "jdbc:mysql://localhost:3306/movies_ninja?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String moviename = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, moviename, password);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movieList = new ArrayList<>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Movie movie = transformFromResultSetToMovie(resultSet);
                movieList.add(movie);

            }

        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }


    @Override
    public Movie getMovieById(int movieID) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM movies WHERE id = ?;");

            preparedStatement.setInt(1, movieID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Movie movie = transformFromResultSetToMovie(resultSet);

                return movie;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Movie transformFromResultSetToMovie(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("year");
        String genre = resultSet.getString("genre");
        String description = resultSet.getString("description");

        return new Movie(id, title, year, genre, description);

    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {

        List<Movie> movieList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM movies WHERE genre = ?;");

            preparedStatement.setString(1, genre);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Movie movie = transformFromResultSetToMovie(resultSet);
                movieList.add(movie);

                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public List<String> getAllGenres() {

        List<String> genres = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT DISTINCT genre from movies;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genres.add(resultSet.getString("genre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    @Override
    public void createMovie(Movie movie) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO movies (title, year, genre, description) VALUES (?, ?, ?, ?)");


            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYear());
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setString(4, movie.getDescription());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateMovie(Movie movie) {

        try {

//            if (getMovieById(movie.getId()) != null) {

                PreparedStatement preparedStatement = connection.prepareStatement
                        ("UPDATE movies SET title= ?, year = ?, genre = ?, description = ?, WHERE id = ?");

                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setInt(2, movie.getYear());
                preparedStatement.setString(3, movie.getGenre());
                preparedStatement.setString(4, movie.getDescription());
                preparedStatement.setInt(5, movie.getId());

                preparedStatement.executeUpdate();
                preparedStatement.close();
//            } else {
//                System.out.println("Nie ma filmu o takim id"); // powinien być rzucony wyjątek
//            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("brak updatu ");
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void deleteMovie(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM movies WHERE id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
