<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>

<div align="center">
<h1> Registration </h1>

<h3> Enter your data to register: </h3>

  <form method="post" action="registration">

   <%
    String invalid = request.getParameter("invalid");
    if(invalid != null) {
   %>
   <strong style="color: red">Login already taken!</strong>
   <%
    }
   %>

   <br/>
   Login:
    <br/>
    <input name="login" type="text">
    <br/>
    Password:
    <br/>
    <input name="password" type="password">
    <br/>
    First Name:
    <br/>
    <input name="firstName" type="text">
    <br/>
    Last Name:
    <br/>
    <input name="lastName" type="text">
    <br/>

    <input type="submit" value="Registration" class="button">


  </form>

<br/>
<a href="login.jsp"> Go back to login! </a>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
