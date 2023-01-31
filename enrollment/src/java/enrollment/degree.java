package enrollment;
import java.sql.*;

public class degree {
    public String degreeid;
    public String degreename;
    
    public degree () {
        degreeid = " ";
        degreename = " ";
    };
    
    public int modRecord()  { 
        try {
            Connection  conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false"); 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE degree SET degreename = ?  WHERE degreeid = ?");
            pstmt.setString(2, degreeid);
            pstmt.setString(1,degreename);
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM degree WHERE degreeid = ?");
            pstmt.setString(1,degreeid);
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO degree (degreeid , degreename) VALUES (?,?)");
            pstmt.setString(1,degreeid);
            pstmt.setString(2, degreename);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT degreeid, degreename FROM degree WHERE degreeid = ?");
            pstmt.setString(1,degreeid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                degreename = rs.getString("degreename");
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
        degree DEGREE = new degree();
        
        /*DEGREE.degreeid   = "BSA";
        DEGREE.degreename = "Test";        
        DEGREE.addRecord();*/
        
        /*DEGREE.degreeid   = "BSA";
        DEGREE.degreename = "Bachelor of Science";
        DEGREE.modRecord();*/
        
        /*DEGREE.degreeid = "BSA";
        DEGREE.delRecord();*/
        
        /*DEGREE.degreeid = "BSIT";
        DEGREE.viewRecord();
        System.out.println(DEGREE.degreeid);
        System.out.println(DEGREE.degreename);*/
    }
}
