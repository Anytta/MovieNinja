<%@ page import="servlets.UserServlet" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="styles.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>

<%@include file="layout/header.jsp" %>


<div class="middle">
  <%@include file="layout/menu.jsp" %>

  <div class="content">
    <h3>List of users:</h3>

    <table style="margin: auto" class="table thead-dark table-bordered table-striped">

  <tr>
   <th> Login </th>
    <th> First Name </th>
    <th> Last Name </th>
  </tr>


    <% List<User> users = (List<User>) request.getAttribute("users");
      for (User user : users) {
    %>
    <tr>
      <td> <%=user.getLogin()%> </td>
      <td> <%=user.getFirstName()%> </td>
      <td> <%=user.getLastName()%> </td>

    </tr>
    <%
      }

    %>

</table>

  </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
