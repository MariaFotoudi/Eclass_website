package ismgroup66_java;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class StudentService {


    public void saveStudent(Student student, User user) throws Exception {

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        String sqlCheck = "SELECT * from student WHERE username=?";

        String sql = "INSERT INTO student (lastname, firstname, email, username) " 
            + " VALUES (?, ?, ?, ?)";

        String sql2 = "INSERT INTO users (username, userpassword) " 
        + " VALUES (?, ?)";

        try {
            
            con = db.getConnection();

            stmt = con.prepareStatement(sqlCheck);
            // setting parameters
            stmt.setString(1, student.getUsername());

            rs = stmt.executeQuery();

            if ( rs.next() ) {
                rs.close();
                stmt.close();
                throw new Exception("Sorry, Username exists!");

            }

            stmt2 = con.prepareStatement(sql2);
            stmt = con.prepareStatement(sql);
          
            stmt2.setString(1, user.getUsername());
            stmt2.setString(2, user.getUserPassword());

            stmt2.executeUpdate();

            // setting parameters
            stmt.setString(1, student.getLastname());
            stmt.setString(2, student.getFirstname());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getUsername());

            stmt.executeUpdate();

            stmt.close();
            stmt2.close();
            db.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

            try {
                db.close();
            } catch (Exception e) {
                
            }

        }

    }

    public void saveStudentsClass(StudentsClass studentsclass) throws Exception {

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "INSERT INTO studentsclass (classid, username) " 
        + " VALUES (?, ?)";

        try {
            con = db.getConnection();

            stmt = con.prepareStatement(sql);

            stmt.setString(1, studentsclass.getClassid());
            stmt.setString(2, studentsclass.getUsername());

            stmt.executeUpdate(); 

            stmt.close();
            db.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

            try {
                db.close();
            } catch (Exception e) {
                
            }

        }

    }


    public Student getStudent(String usern) throws Exception {

        Student st = null;

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student where username =?";
     
        try {

            con = db.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usern);

            rs = stmt.executeQuery();

            while ( rs.next() ) {
                st = new Student(rs.getString("student.lastname"), rs.getString("student.firstname"),rs.getString("student.email"), rs.getString("student.username"));
		int points=rs.getInt("sumpoints");
		st.setSumpoints(points);
            }

            rs.close();
            stmt.close();
            db.close();

            return st;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
        }

    }
    public List<StudentsClass> getStudentsClass(String usern) throws Exception {

        List<StudentsClass> studentsclasses = new ArrayList<StudentsClass>();

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM studentsclass where username =?";
     
        try {

            con = db.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usern);

            rs = stmt.executeQuery();

            while ( rs.next() ) {
                StudentsClass studentsclass = new StudentsClass(rs.getString("studentsclass.classid"), rs.getString("studentsclass.username"));
                studentsclasses.add(studentsclass);
            }

            rs.close();
            stmt.close();
            db.close();

            return studentsclasses;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
        }

    }

    
}