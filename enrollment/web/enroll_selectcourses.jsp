<%@page import="enrollment.coursedegree"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enroll</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session"/>
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="session"/>
        <%if (enrollBean.CourseList.size() == 0)
            enrollBean.loadCourses();%>
        <form name="enroll_courseselect" action="enroll_addtocart.jsp" request="POST">
            Select Courses <select name="enroll_courses" id="enroll_courses">
                <%for (int i = 0; i < enrollBean.CourseList.size(); i++) {
                coursedegree cd = enrollBean.CourseList.get(i);%>
                <option value="<%=cd.courseid%>"> <%=cd.courseid%> </option>
                <%}%>
            </select><br>
            Enter Term: <input type="text" name="enroll_term" id="enroll_term"><br>
            Enter School Year: <input type="text" name="enroll_schoolyear" id="enroll_schoolyear"><br>
            <input type="submit" name="ernoll_addtocart" value="Add Course to Cart">
        </form>
            <br><br>
            Enrollment Cart:<br>
            <%for (int i = 0; i < enrollBean.EnrollmentList.size(); i++) {
                 out.println(enrollBean.EnrollmentList.get(i).courseid); %>
                 <br>
                <%}%>
                <form name="ernoll_confirmcart" action="enroll_confirm.jsp" request="POST">
                    <input type="submit" name="enroll_confirm" value="Confirm enrollment">
                </form>
                <form name="enroll_resetcart" action="enroll_resetcart.jsp" request="POST">
                    <input type="submit" name="enroll_reset" value="Clear Cart">
                </form>
    </body>
</html> 