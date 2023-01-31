package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
    
    
    // perform all the necessary data loading from DB 
    public enroll() {};
    
    // clears enrollment data of the student 
    public int clearEnrollment ()   {   
        this.EnrollmentList.clear();
        this.CourseList.clear();
        return 0;
    }

    // load valid courses into the course list
    public int loadCourses ()       {   
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, degree FROM coursedegree WHERE degree= ? AND courseid NOT IN (SELECT courseid FROM enrollment WHERE studentid= ?);");
            pstmt.setString(1,this.Student.degreeid);
            pstmt.setLong(2,this.Student.studentid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                coursedegree course = new coursedegree();
                course.courseid = rs.getString("courseid");
                course.degree = rs.getString("degree");
                this.CourseList.add(course);
            }
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }  
    }

    // saves enrollment data into the Database
    public int confirmEnrollment()  {
        for (enrollment e : this.EnrollmentList) {
                e.addRecord();
            }
        this.clearEnrollment();
        return 0; 
    }
    
    public void addToCart(String courseid, int term, int schoolyear) {
        enrollment e = new enrollment();
        e.courseid = courseid;
        e.studentid = this.Student.studentid;
        e.term = term;
        e.schoolyear = schoolyear;
        this.EnrollmentList.add(e);
    }
    
    public static void main(String args[]) {
        enroll ENROLL = new enroll();
//        e.Student.studentid = 10100012;
//        e.Student.viewRecord();
//        
//        // Load courses test (PASSED)
//        e.loadCourses();
//        for (coursedegree cd : e.CourseList) {
//            System.out.println(cd.courseid + " " + cd.degree);
//        }
//        
//        // Confirm enrollment (PASSED)
//        enrollment en1 = new enrollment();
//        en1.studentid = e.Student.studentid;
//        en1.courseid = "CCPROG1";
//        en1.term = 2;
//        en1.schoolyear = 2019;
//        
//        enrollment en2 = new enrollment();
//        en2.studentid = e.Student.studentid;
//        en2.courseid = "CCICOMP";
//        en2.term = 2;
//        en2.schoolyear = 20192020;
//        
//        e.EnrollmentList.add(en1);
//        e.EnrollmentList.add(en2);
//        
//        for (enrollment en : e.EnrollmentList) {
//            System.out.println(en.studentid);
//            System.out.println(en.courseid);
//            System.out.println(en.term);
//            System.out.println(en.schoolyear);
//        }
//        
//        e.confirmEnrollment();
//        System.out.println(e.EnrollmentList.size());
//        
//        // Clear enrollment (PASSED)
//        e.clearEnrollment();
    }
    
}
