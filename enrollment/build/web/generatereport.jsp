<%-- 
    Document   : generatereport
    Created on : 02 4, 22, 7:35:19 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Generated</title>
    </head>
    <body>
        <jsp:useBean id="reportBean" class="enrollment.report" scope="session"/>
            <%  String term = request.getParameter("term");
                String schoolyear = request.getParameter("schoolyear"); 
                String courseid;
                String enrolledStudents;
                
                reportBean.term = Integer.parseInt(term);
                reportBean.schoolyear = Integer.parseInt(schoolyear);
                reportBean.generate();
            %>
            <h1>Statistics for Term: <%=term%>, School Year: <%=schoolyear%></h1><br>
            <%    for(int i = 0; i < reportBean.courses.size() && i < reportBean.number.size(); i++) {
                    courseid = reportBean.courses.get(i);
                    enrolledStudents = Integer.toString(reportBean.number.get(i));
            %>
                    <%=courseid%>, <%=enrolledStudents%><br>
            <%  }
            %>
            <a href="report.jsp">Click here to go back to generate report section</a><br>
    </body>
</html>
