package model;

public class MovieRental {

    private String login;
    private Integer movieId;

    public MovieRental(String login, Integer movieId) {
        this.login = login;
        this.movieId = movieId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "MovieRental{" +
                "login='" + login + '\'' +
                ", movieId=" + movieId +
                '}';
    }

}
