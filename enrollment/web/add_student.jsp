<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Record</title>
    </head>
    <body>
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="session" />
        <% String studentid = request.getParameter("studentid");
           String completename = request.getParameter("completename");
           String degreeid = request.getParameter("degreeid"); 
            
           studentsBean.studentid  = Integer.parseInt(studentid);
           studentsBean.completename        = completename;
           studentsBean.degreeid        = degreeid;
            
           studentsBean.addRecord(); %>
            
           Record added.<br>
           <a href="studentmaintenance.jsp">Click here to add another record.</a><br>
    </body>
</html>
