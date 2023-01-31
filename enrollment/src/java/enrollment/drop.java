/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
  
    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();

    // perform all the necessary data loading from DB
    public drop() {}

    // clears dropping data of the student
    public int clearDrop () {
        this.DropList.clear();
        this.EnrollmentList.clear();
        return 0;
    }

    // load enrollment data of the student
    public int loadEnrollment (int SchoolYear, int Term) {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            PreparedStatement pstmt = conn.prepareStatement("SELECT studentid, courseid, term, schoolyear FROM enrollment WHERE studentid=? AND schoolyear=? AND term=?");
            pstmt.setLong(1,this.Student.studentid);
            pstmt.setInt(2,SchoolYear);
            pstmt.setInt(3,Term);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                enrollment enrolled = new enrollment();
                enrolled.studentid = rs.getLong("studentid");
                enrolled.courseid = rs.getString("courseid");
                enrolled.term = rs.getInt("term");
                enrolled.schoolyear = rs.getInt("schoolyear");
                this.EnrollmentList.add(enrolled);
            }

            pstmt.close();
            conn.close();
            return 1;
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // saves dropping data into the Database
    public int confirmDrop() {
        for (enrollment e : this.DropList) {
            e.delRecord();
        }
        return 0;
    }
    
    public void addToDrop(String courseid, int term, int year) {
        enrollment e = new enrollment();
        e.courseid = courseid;
        e.schoolyear = year;
        e.term = term;
        e.studentid = this.Student.studentid;
        this.DropList.add(e);
    }

    public static void main(String args[]) {
        drop DROP = new drop();
//        d.Student.studentid = 10100012;
//        d.Student.viewRecord();
//
//        // Load enrollment test (PASSED)
//        d.loadEnrollment(20192020, 2);
//        System.out.println(d.EnrollmentList.size());
//        for (enrollment e : d.EnrollmentList) {
//            System.out.println(e.studentid + " " + e.courseid + " " + e.term + " " + e.schoolyear);
//                }
//        
//        // Drop Clear test (PASSED)
//        d.DropList.add(d.EnrollmentList.get(1));
//       for (enrollment e : d.DropList) {
//            System.out.println(e.studentid + " " + e.courseid + " " + e.term + " " + e.schoolyear);
//        }
//        
//        d.clearDrop();
//        
//        // Confirm drop test (PASSED)
//        d.confirmDrop(); 
        } 
    }
