<%-- 
    Document   : drop
    Created on : 02 3, 22, 2:14:07 PM
    Author     : ccslearner
--%>

<%-- should have load student data, select course to drop, add to drop cart, has drop --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DROP ENROLLED COURSES</title>
    </head>
    <body>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session"/>
        <h1>Enter Student Details</h1>
        <form name="studentdetails" action="load_courses.jsp" method="POST">
        Student ID: <input type="text" name="studentid" id="studentid"><br>
        Term: <input type="text" name="term" id="term"><br>
        School Year: <input type="text" name="schoolyear" id="schoolyear"><br>
        <input type="submit" value="loadcourses" name="loadcourses"><br><br>
        </form>
        
        
   
        
   
 
    </body>
</html>
