<%@ page import="servlets.UserServlet" %>
<%@ page import="model.User" %>
<%@ page import="model.Movie" %>
<%@ page import="view.MoviesListServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="model.MovieRental" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>

<div class="middle">
  <%@include file="layout/menu.jsp" %>

    <div align = "center">
  <div class="content">
    <h3>Rentals:</h3>


      <table class="table" style= "width: 40%">

  <thead  style="color: cadetblue">
  <tr>
   <th> user </th>
    <th> movieId </th>

  </tr>
  </thead>

    <%
        List<MovieRental> rentals = (List<MovieRental>) request.getAttribute("rentals");

        for (MovieRental movie : rentals ) { %>
    <tr>
      <td > <%=movie.getLogin()%> </td>
      <td style= "width: 30%"> <%=movie.getMovieId()%> </td>


    </tr>

          <%  } %>
</table>

  </div>
</div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
