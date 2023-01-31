package enrollment;
import java.sql.*;
import java.util.*;

/**
 * Report Generation Code for Report
 */
public class report {
    
    public int term;
    public int schoolyear;
    public ArrayList<String> courses = new ArrayList<>();
    public ArrayList<Integer> number = new ArrayList<>();
    
    public report(){
           
        term                = 0;
        schoolyear          = 0;
        courses.clear();
        number.clear();

    }

    public int clearReport(){

        term                = 0;
        schoolyear          = 0;
        courses.clear();
        number.clear();

        return 0;

    }

    public int generate(){

        try{

            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement pstmt = conn.prepareStatement("SELECT     e.courseid, COUNT(e.studentid) AS numOfStudents                " 
                                                         +
                                                            "FROM       enrollment e                                                   "   
                                                         +
                                                            "WHERE      e.term              = ?                                        " 
                                                         +
                                                            "AND        e.schoolyear        = ?                                        "  
                                                         +
                                                            "GROUP BY   e.term, e.courseid                                             " 
                                                         +
                                                            "ORDER BY   e.courseid, e.term                                             ");


            pstmt.setInt(1, term);
            pstmt.setInt(2, schoolyear);
            ResultSet rs = pstmt.executeQuery();
            courses.clear();
            number.clear();
            while(rs.next()){

               courses.add(rs.getString("e.courseid"));
               number.add(rs.getInt("numOfStudents"));

            }

            rs.close();
            pstmt.close();
            conn.close();

            return 1;

        } catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;

        }

    }


    public static void main(String[] args){

        report rpt = new report();
        
        /*rpt.term = 1;
        rpt.schoolyear = 20192020;
        rpt.generateReport();*/
        
        rpt.term = 2;
        rpt.schoolyear = 20192020;
        rpt.generate();
        
        String courseid = "";
        int enrolledStudents = 0;
        
        System.out.println("Term = " + rpt.term);
        System.out.println("School year = " + rpt.schoolyear);
        System.out.println ("\nNumber of students enrolled:");
        
      
        for(int i = 0; i < rpt.courses.size() && i < rpt.number.size(); i++){

            courseid = rpt.courses.get(i);
            enrolledStudents = rpt.number.get(i);
            System.out.printf("%s - %d\n", courseid, enrolledStudents);
        }
    }    

}
