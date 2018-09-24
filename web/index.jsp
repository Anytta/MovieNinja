<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Movie Ninja</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>

<div class="middle">
  <%@include file="layout/menu.jsp" %>

  <div class="content">
    <h3> Welcome to MoviesNinja!</h3>
    <br/>
   <p> Go to the <i> List of movies </i> to chose the one that you want to rent
      or check <i> My movies </i> to see what you have already rented
   </p>

  </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
