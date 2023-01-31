<%-- 
    Document   : submitdrop
    Created on : 02 3, 22, 2:15:42 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dropped</title>
    </head>
    <body>
        <h1>Courses Dropped Successfully</h1>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session"/>
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="session"/>
        
        <%  
            dropBean.confirmDrop();
            dropBean.clearDrop();
            String dropsize = Integer.toString(dropBean.DropList.size()); //debug purposes
        %>
        
        <!-- For debug purposes, remove if done
        DropList Array Size: <%=dropsize%>
        Student ID: <%=dropBean.Student.studentid%><br>
        Term: <%=enrollmentBean.term%><br>
        School Year: <%=enrollmentBean.schoolyear%><br>
        Course ID: <%=enrollmentBean.courseid%><br>
        -->
        <a href="drop.jsp">Click here to go back to drop course section</a><br>
    </body>
</html>
