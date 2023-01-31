package enrollment;
import java.sql.*;

public class courses {
    
    public  String courseid;
    public  String coursename;
    public  String department;
    
    public courses () {
    
        courseid   = "";
        coursename = "";
        department = "";
    };
    public int modRecord()  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE courses SET coursename = ?, department = ? WHERE courseid = ?");
            pstmt.setString(3,courseid);
            pstmt.setString(1, coursename);
            pstmt.setString(2,department);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } 
    };
    
    
    
    public int delRecord()  { 
         try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM courses WHERE courseid = ?");
            pstmt.setString(1,courseid);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    };
    
    
    
    public int addRecord()  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO courses (courseid , coursename, department) VALUES (?,?,?)");
            pstmt.setString(1,courseid);
            pstmt.setString(2, coursename);
            pstmt.setString(3,department);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    };
    
    
    
    public int viewRecord() { 
        
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, coursename, department FROM courses WHERE courseid = ?");
            pstmt.setString(1,courseid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                coursename = rs.getString("coursename");
                department   = rs.getString("department");
            }
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }  
    };
    
    
    
    
    
    public static void main(String args[]) {
        
        courses COURSES = new courses();
        
        /*COURSES.courseid   = "ISSYSAD";
        COURSES.coursename = "System Administration";
        COURSES.department = "Information Systems";
        COURSES.addRecord();*/
        
        /*COURSES.courseid   = "ISSYSAD";
        COURSES.coursename = "Edit";
        COURSES.department = "Information Technology";
        COURSES.modRecord();*/
      
        /*COURSES.courseid = "ISSYSAD";
        COURSES.delRecord(); */
        
        /*COURSES.courseid = "CCINFOM";
        COURSES.viewRecord();
        System.out.println(COURSES.coursename);
        System.out.println(COURSES.department);*/
        
    }
}
