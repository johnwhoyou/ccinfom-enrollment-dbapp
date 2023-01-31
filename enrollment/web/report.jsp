<%-- 
    Document   : report
    Created on : 02 4, 22, 7:34:52 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate a Report</title>
    </head>
    <body>
        <h1>Enter Details</h1>
        <form name="schooldetails" action="generatereport.jsp" method="POST">
        Term: <input type="text" name="term" id="term"><br>
        School Year: <input type="text" name="schoolyear" id="schoolyear"><br>
        <input type="submit" value="generatereport" name="generatereport"><br><br>
        </form>
    </body>
</html>
