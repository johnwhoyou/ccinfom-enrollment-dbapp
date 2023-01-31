package enrollment;
import java.sql.*;

public class students {
    
    public  long  studentid;
    public  String completename;
    public  String degreeid;
            
    public students () {
    
    studentid    = 0;
    completename = "";
    degreeid     = "";
    
    };
    public int modRecord()  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE students SET completename = ?, degreeid = ? WHERE studentid = ?");
            pstmt.setLong(3,studentid);
            pstmt.setString(1, completename);
            pstmt.setString(2,degreeid);
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE studentid = ?");
            pstmt.setLong(1,studentid);
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (studentid , completename, degreeid) VALUES (?,?,?)");
            pstmt.setLong(1,studentid);
            pstmt.setString(2, completename);
            pstmt.setString(3,degreeid);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT studentid, completename, degreeid FROM students WHERE studentid = ?");
            pstmt.setLong(1,studentid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                completename = rs.getString("completename");
                degreeid   = rs.getString("degreeid");
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
       
        students STUDENTS = new students();
        
        /*STUDENTS.studentid=10000019;
        STUDENTS.completename= "Nicole Tabije";
        STUDENTS.degreeid="BSIS";
        STUDENTS.addRecord();*/
        
        /*STUDENTS.studentid=10000019;
        STUDENTS.completename= "Angela";
        STUDENTS.degreeid="BSIT";
        STUDENTS.modRecord();*/

        /*STUDENTS.studentid = 10000019;
        STUDENTS.delRecord();*/
        
        /*STUDENTS.studentid = 10100005;
        STUDENTS.viewRecord();
        System.out.println(STUDENTS.completename);
        System.out.println(STUDENTS.degreeid);*/

    }
}