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
    <h3> You are already loged in! </h3>
 If you want to change the user, log out first.
  </div>
</div>

<%@include file="layout/footer.jsp" %>

</body>
</html>
