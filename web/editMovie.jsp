<%@ page import="model.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Movie</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@include file="layout/header.jsp" %>
<div class="middle">
    <%@include file="layout/menu.jsp" %>

    <div class="content">

      <h3>  Edit movie: </h3>

        <form method="post" action="editMovie">


            <% Movie movie = (Movie) request.getAttribute("movie"); %>

            <input name="id" type="hidden" value="<%=movie.getId()%>">
            <br/>
            Title:
            <br/>
            <input name="title" type="text" value="<%=movie.getTitle()%>">
            <br/>
            Year:
            <br/>
            <input name="year" type="number" value="<%=movie.getYear()%>">
            <br/>
            Genre:
            <br/>
            <input name="genre" type="text" value="<%=movie.getGenre()%>">
            <br/>
            Description:
            <br/>
            <textarea rows="20" cols="20" name="description"> <%=movie.getDescription()%> </textarea>
            <br/>

            <input type="submit" value="Save changes" class="button">


        </form>

    </div>
</div>


<%@include file="layout/footer.jsp" %>

</body>
</html>
