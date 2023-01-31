<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Record</title>
    </head>
    <body>
        <jsp:useBean id="coursesBean" class="enrollment.courses" scope="session" />
        <% 
            String courseid             = request.getParameter("courseid");          
            coursesBean.courseid        = courseid;       
            coursesBean.viewRecord(); 
        %>
        Course ID:                            
        <%= coursesBean.courseid %>
        <br> 
        Course Name: 
        <%= coursesBean.coursename %>
        <br>
        Department: 
        <%= coursesBean.department %> 
        <br>
        
                                           
            <a href="coursemaintenance.jsp">Click here to add, modify or delete records.</a><br>
    </body>
</html>
