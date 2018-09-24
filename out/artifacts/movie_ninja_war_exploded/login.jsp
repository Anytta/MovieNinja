<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>
<div align="center">
<h2 style = "margin-top: 20px"> Please login: </h2>


<%
    String username = (String) session.getAttribute("username");
    if(username != null){
        response.sendRedirect(response.encodeRedirectURL("alreadyLogged.jsp"));
    }

    String invalid = request.getParameter("invalid");
    if(invalid != null) {
%>
<strong style="color: red">Wrong data!</strong>
<%
    }
%>

<form method="post" action="login">
<br/>
Login:
<br/>
<input name="username" type="text">
<br/>
Password:
<br/>
<input name="password" type="password">
<br/>
<input type="submit" value="login" class="button">

</form>

<br/>

<a href="register.jsp"> Register </a>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
