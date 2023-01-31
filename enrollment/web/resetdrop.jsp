<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Drop</title>
    </head>
    <body>
         <jsp:useBean id="dropBean" class="enrollment.drop" scope="session"/>
         <%dropBean.clearDrop();%>
        <h1>Drop list has been reset. </h1>
        <a href="index.html">Main menu</a>
    </body>
</html>
