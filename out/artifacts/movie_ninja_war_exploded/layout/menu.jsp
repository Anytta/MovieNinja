    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        </head>
        <body>
        <div class="menu">

            <%
            String role = (String) session.getAttribute("role");

//                boolean isAdmin = role != null && role.equals("admin");
            boolean isAdmin = "admin".equals(role);
        %>

        <ul>

            <li>   <a href="about.jsp">  About us </a> </li>
            <li>   <a href="contact.jsp">  Contact  </a> </li>
            <li>   <a href="moviesList">  List of movies  </a> </li>
            <li>   <a href="myRentals">  My movies  </a> </li>

            <% if (isAdmin) { %>
            <li>   <a href="usersList">  List of users </a> </li>
            <li>   <a href="enterMovie.jsp">  Add new movie  </a> </li>
            <li>   <a href="rentals">  Rented movies  </a> </li>
            <% } %>

            <li>   <a href="logout">  Logout  </a> </li>
        </ul>
        </div>
        </body>
        </html>
