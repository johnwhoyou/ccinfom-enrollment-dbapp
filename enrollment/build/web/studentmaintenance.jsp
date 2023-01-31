<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Record Maintenance</title>
    </head>
    </body> 
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="session" />
        Add Record<br>
        <form name="studentmaintenance" action="add_student.jsp" method="POST">
        Enter Student ID: <input type="text" name="studentid" id="studentid"><br>
        Enter Complete Name: <input type="text" name="completename" id="completename"><br>
        Enter Degree ID: <input type="text" name="degreeid" id="degreeid"><br>
        <input type="submit" value="addrecord" name="addrecord"><br><br>
        </form>
        
        Modify Record<br>
        <form name="studentmaintenance" action="mod_student.jsp" method="POST">
        Enter Student ID: <input type="text" name="studentid" id="studentid"><br>
        Enter Complete Name: <input type="text" name="completename" id="completename"><br>
        Enter Degree ID: <input type="text" name="degreeid" id="degreeid"><br>
        <input type="submit" value="modrecord" name="modrecord"><br><br>
        </form>
        
        Delete Record<br>
        <form name="studentmaintenance" action="del_student.jsp" method="POST">
        Enter Student ID: <input type="text" name="studentid" id="studentid"><br>
        
        <input type="submit" value="delrecord" name="delrecord"><br><br>
        </form>
        
        View Record<br>
        <form name="studentmaintenance" action="loadstudentdata.jsp" method="POST">
        Enter Student ID: <input type="text" name="studentid" id="studentid"><br>
        
        <input type="submit" value="viewrecord" name="viewrecord"><br><br>
        </form>
        
        
        <a href="index.html">Go to main menu</a>
    </body>   
</html>
