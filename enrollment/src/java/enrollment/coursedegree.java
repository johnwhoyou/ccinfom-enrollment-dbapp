package enrollment;
import java.sql.*;

public class coursedegree {
    public String courseid;
    public String degree;
    
    
    public coursedegree () {
        courseid = " ";
        degree = " ";
       
    };
    
   
    public int modRecord(String newcourseid, String newdegree)  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree SET courseid = ?, degree = ? WHERE courseid = ? AND degree = ?");
            pstmt.setString(1, newcourseid);
            pstmt.setString(2,newdegree);
            pstmt.setString(3,courseid);
            pstmt.setString(4,degree);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            this.courseid = newcourseid;
            this.degree = newdegree;
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM coursedegree WHERE courseid = ? AND degree = ?");
            pstmt.setString(1,courseid);
            pstmt.setString(2,degree);
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO coursedegree (courseid , degree) VALUES (?,?)");
            pstmt.setString(1,courseid);
            pstmt.setString(2, degree);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid , degree FROM coursedegree WHERE courseid = ? AND degree = ?");
            pstmt.setString(1,courseid);
            pstmt.setString(2,degree);
            ResultSet rs = pstmt.executeQuery();
             while (rs.next()) {
                courseid = rs.getString("courseid");
                degree = rs.getString("degree");
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
        coursedegree COURSEDEGREE = new coursedegree();
        
        //MODIFY
        /*COURSEDEGREE.courseid = "ISINFOM";
        COURSEDEGREE.degree = "BSIT";
        COURSEDEGREE.modRecord("ISINFOM", "BSIS");*/
        
        //ADD
         
        /*COURSEDEGREE.courseid = "ISINFOM";
        COURSEDEGREE.degree = "BSIT";
        COURSEDEGREE.addRecord();*/
      
        //DELETE
        /*COURSEDEGREE.courseid = "ISINFOM";
        COURSEDEGREE.degree = "BSIT";
        COURSEDEGREE.delRecord();*/
     
   
        //VIEW
        /*COURSEDEGREE.courseid = "CCPROG3";
        COURSEDEGREE.degree = "BSIS";
        COURSEDEGREE.viewRecord();
        System.out.println(COURSEDEGREE.courseid);
        System.out.println(COURSEDEGREE.degree);*/
         
        
    }
}
