<%@ page import="servlets.UserServlet" %>
<%@ page import="model.User" %>
<%@ page import="model.Movie" %>
<%@ page import="view.MoviesListServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="view.DTO.MovieDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>

<div class="middle">
  <%@include file="layout/menu.jsp" %>

  <div class="content">
    <h3>List of movies:</h3>

      <%
          String userRole = (String) session.getAttribute("role");

//                boolean isAdmin = role != null && role.equals("admin");
         isAdmin = "admin".equals(userRole);
      %>


      <table class="table" >

  <thead class="thead-dark">
  <tr>
   <th> Id </th>
    <th> Title </th>
    <th> Year </th>
    <th> Genre </th>
    <th> Description </th>
      <th> Action </th>

      <% if (isAdmin) { %>
      <th>  </th>
      <th> </th>
      <% } %>


  </tr>
  </thead>

    <%
        List<MovieDTO> allMoviesList = (List<MovieDTO>) request.getAttribute("movies");
//        String role = (String) session.getAttribute("role");
//        boolean isAdmin = "admin".equals(role);

        for (MovieDTO movie : allMoviesList) { %>
    <tr>
      <td> <%=movie.getId()%> </td>
      <td> <%=movie.getTitle()%> </td>
      <td> <%=movie.getYear()%> </td>
      <td> <%=movie.getGenre()%> </td>
      <td> <%=movie.getDescription()%> </td>


        <%   if(!movie.isRent()){ %>
        <td> <a href="rent?movieId=<%=movie.getId()%>"> Rent </a> </td>
        <%} %>

        <%   if(movie.isRent()){ %>
        <td> <a href="return?movieId=<%=movie.getId()%>"> Return </a></td>
        <%} %>

        <% if (isAdmin) { %>
        <td> <a href=" deleteMovie?id=<%=movie.getId()%>"> Delete </a></td>
        <td> <a href=" editMovie?id=<%=movie.getId()%>"> Edit </a></td>
        <% } %>
    </tr>
    <% } %>

</table>

  </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
