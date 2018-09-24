    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <title>Movie Ninja</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

        </head>
        <body>
        <div class="header">
        MovieNinja!

                    <%   if(session.getAttribute("username") != null) { %>

            <span class="logged"> You are logged in as: <%=session.getAttribute("username")%></span>
                    <%} %>

        </div>
        </body>
        </html>
