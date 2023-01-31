<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Record Maintenance</title>
    </head>
    </body> 
        <jsp:useBean id="coursesBean" class="enrollment.courses" scope="session" />
        Add Record<br>
        <form name="coursemaintenance" action="add_course.jsp" method="POST">
        Enter Course ID: <input type="text" name="courseid" id="courseid"><br>
        Enter Course Name: <input type="text" name="coursename" id="coursename"><br>
        Enter Department: <input type="text" name="department" id="department"><br>
        <input type="submit" value="addrecord" name="addrecord"><br><br>
        </form>
        
        Modify Record<br>
        <form name="coursemaintenance" action="mod_course.jsp" method="POST">
        Enter Course ID: <input type="text" name="courseid" id="courseid"><br>
        Enter Course Name: <input type="text" name="coursename" id="coursename"><br>
        Enter Department: <input type="text" name="department" id="department"><br>
        <input type="submit" value="modrecord" name="modrecord"><br><br>
        </form>
        
        Delete Record<br>
        <form name="coursemaintenance" action="del_course.jsp" method="POST">
        Enter Course ID: <input type="text" name="courseid" id="courseid"><br>
        <input type="submit" value="delrecord" name="delrecord"><br><br>
        </form>       
         
        View Record<br>
        <form name="coursemaintenance" action="loadcoursedata.jsp" method="POST">
        Enter Course ID: <input type="text" name="courseid" id="courseid"><br>
        
        <input type="submit" value="viewrecord" name="viewrecord"><br><br>
        </form>

        <a href="index.html">Go to main menu</a>
    </body>   
</html>
