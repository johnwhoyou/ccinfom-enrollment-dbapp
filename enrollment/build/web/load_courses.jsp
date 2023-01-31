<%-- 
    Document   : load_student
    Created on : 02 3, 22, 8:24:03 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Load Courses</title>
    </head>
    <body>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session"/>
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="session"/>
        <form name="selectcourse" action="addtodrop.jsp" method="POST">
            <%  String studentid = request.getParameter("studentid");
                String term = request.getParameter("term");
                String schoolyear = request.getParameter("schoolyear"); 
                dropBean.Student.studentid  = Integer.parseInt(studentid);
                enrollmentBean.term =Integer.parseInt(term);
                enrollmentBean.schoolyear =Integer.parseInt(schoolyear);
                dropBean.loadEnrollment(Integer.parseInt(schoolyear), Integer.parseInt(term));
            %>
            Student ID: <%=dropBean.Student.studentid%><br>
            School Year: <%=schoolyear%><br>
            Term: <%=term%><br>
            <h1>Select Courses to Drop</h1>
            <%
                for (int i=0; i<dropBean.EnrollmentList.size(); i++) {
                    enrollmentBean = dropBean.EnrollmentList.get(i);
            %>
                <input type="checkbox" id="<%=enrollmentBean.courseid%>" name="courseid" value="<%=enrollmentBean.courseid%>">
                <label for="<%=enrollmentBean.courseid%>"><%=enrollmentBean.courseid%></label><br>
            <%  }
            %>
            <input type="submit" value="add to drop" name="adddrop">
        </form>
    </body>
</html>
