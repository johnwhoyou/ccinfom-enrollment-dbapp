<%--<%@page import="enrollment.enrollment"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get User Info For Enrollment</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session"/>
         <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="session"/>
        <%
            String courseEnrolled = request.getParameter("enroll_courses");
            String term = request.getParameter("enroll_term");
            String schoolyear = request.getParameter("enroll_schoolyear");
//            enrollmentBean.studentid = enrollBean.Student.studentid;
//            enrollmentBean.schoolyear = Integer.parseInt(schoolyear);
//            enrollmentBean.term = Integer.parseInt(term);
//            enrollmentBean.courseid = courseEnrolled;
//            enrollBean.EnrollmentList.add(enrollmentBean);
            enrollBean.addToCart(courseEnrolled, Integer.parseInt(term), Integer.parseInt(schoolyear));
        %>
        <a href="enroll_selectcourses.jsp">Go to course selection</a>
    </body>
</html> 