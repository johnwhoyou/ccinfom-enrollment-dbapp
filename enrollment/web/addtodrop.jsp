<%-- 
    Document   : addtodrop
    Created on : 02 3, 22, 2:15:21 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses to Drop</title>
    </head>
    <body>
        <h1>Dropping Cart</h1>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session"/>
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="session"/>
        <form name="dropcourse" action="submitdrop.jsp" method="POST">
        <%  
            String courseid[] = request.getParameterValues("courseid");
            for (int i=0; i<courseid.length; i++) {
                enrollmentBean.courseid = courseid[i];
//                dropBean.DropList.add(enrollmentBean
                dropBean.addToDrop(enrollmentBean.courseid, enrollmentBean.term, enrollmentBean.schoolyear);
            }
            String dropsize = Integer.toString(dropBean.DropList.size()); //debug purposes
        %>
        <% for (int i=0; i<courseid.length; i++) { %>
            <%=courseid[i]%><br>
        <%  }
        %>
        <!-- For debug purposes, remove if done
        DropList Array Size: <%=dropsize%>
        -->
   
        <!-- For debug purposes, remove if done
        Student ID: <%=dropBean.Student.studentid%><br>
        Term: <%=enrollmentBean.term%><br>
        School Year: <%=enrollmentBean.schoolyear%><br>
        Course ID: <%=enrollmentBean.courseid%><br>
        -->
            <input type="submit" value="dropcourses" name="dropcourses">
        </form>
        <form name="resetdroplist" action="resetdrop.jsp" method="POST">
            <input type="submit" value="resetdrop" name="resetdrop">
        </form>
    </body>
</html>
