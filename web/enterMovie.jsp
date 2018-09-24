<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add movie</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>

<div align="center">
<h2 style="margin-top: 20px"> Add a movie: </h2>

<%
String invalid = request.getParameter("invalid");
if(invalid != null) {
%>
<strong style="color: red">Please enter correct data</strong>

<%} %>

  <form method="post" action="addMovie">


    <br/>
    Title:
    <br/>
    <input name="title" type="text">
    <br/>
    Year:
    <br/>
    <input name="year" type="number">
    <br/>
    Genre:
    <br/>
    <select name="genre">
      <option value="comedy">Comedy</option>
      <option value="drama">Drama</option>
      <option value="fantasy">Fantasy</option>
    </select>
    <br/>
    Description:
    <br/>
    <input name="description" type="text">
    <br/>

    <input type="submit" value="Add Movie" class="button">


  </form>

  <a href="moviesList"> Go back to Movie List </a>

</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
