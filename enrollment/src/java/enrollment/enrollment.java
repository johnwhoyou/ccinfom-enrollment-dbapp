package enrollment;
import java.sql.*;

public class enrollment {
    public long     studentid;
    public String   courseid;
    public int      term;
    public int      schoolyear;
    
    public enrollment () {
        studentid = 0;
        courseid = " ";
        term = 0;
        schoolyear = 0;
    };
    
    public int modRecord(long newstudentid, String newcourseid, int newterm, int newschoolyear)  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE enrollment SET studentid = ?, courseid = ?, term = ?, schoolyear = ? WHERE studentid = ? AND courseid = ? AND term = ? AND schoolyear = ?");
            pstmt.setLong(1, newstudentid);
            pstmt.setString(2,newcourseid);
            pstmt.setInt(3,newterm);
            pstmt.setInt(4,newschoolyear);
            pstmt.setLong(5,studentid);
            pstmt.setString(6,courseid);
            pstmt.setInt(7,term);
            pstmt.setInt(8,schoolyear);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            this.studentid = newstudentid;
            this.courseid = newcourseid;
            this.term = newterm;
            this.schoolyear = newschoolyear;
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM enrollment WHERE studentid = ? AND courseid=? AND term=? AND schoolyear=?");
            pstmt.setLong(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollment (studentid, courseid, term, schoolyear) VALUES (?,?,?,?)");
            pstmt.setLong(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT studentid, courseid, term, schoolyear FROM enrollment WHERE studentid = ? AND courseid=? AND term=? AND schoolyear=?");
            pstmt.setLong(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                studentid = rs.getLong("studentid");
                courseid = rs.getString("courseid");
                term = rs.getInt("term");
                schoolyear = rs.getInt("schoolyear"); 
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
        enrollment ENROLLMENT = new enrollment();
        
        // MODIFY
//        ENROLLMENT.studentid = 10100001;
//        ENROLLMENT.courseid = "CCPROG1";
//        ENROLLMENT.term = 1;
//        ENROLLMENT.schoolyear = 20192020;
        
//        ENROLLMENT.newstudentid = 10100001;
//        ENROLLMENT.newcourseid = "CCPROG1";
//        ENROLLMENT.newterm = 2;
//        ENROLLMENT.newschoolyear = 20192020;
        
//        ENROLLMENT.modRecord(10100001, "CCPROG1", 2, 20192020); 
        
        // ADD
        /* ENROLLMENT.newstudentid = 10100001 ;
        ENROLLMENT.newcourseid = "CCPROG2";
        ENROLLMENT.newterm = 1 ;
        ENROLLMENT.newschoolyear = 20192020;
        ENROLLMENT.addRecord();
        
        //DELETE
        ENROLLMENT.oldstudentid = 10100001 ;
        ENROLLMENT.oldcourseid = "CCPROG2";
        ENROLLMENT.oldterm = 2;
        ENROLLMENT.oldschoolyear = 20192020;
        ENROLLMENT.delRecord();
        
        // VIEW
        ENROLLMENT.oldstudentid = 10100001;
        ENROLLMENT.oldcourseid = "CCPROG1";
        ENROLLMENT.oldterm = 1;
        ENROLLMENT.oldschoolyear = 20192020;
        ENROLLMENT.viewRecord();
        
        System.out.println(ENROLLMENT.oldstudentid);
        System.out.println(ENROLLMENT.oldcourseid);
        System.out.println(ENROLLMENT.oldterm);
        System.out.println(ENROLLMENT.oldschoolyear); */
        
        
        
        
    }
}
