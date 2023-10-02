package ismgroup66_java;

import java.sql.*;

public class TeacherService {

    public Teacher getTeacherByClass(String classid) throws Exception {

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT teacherid FROM classes WHERE classid=?;";

        try {
            
            con = db.getConnection();
            stmt = con.prepareStatement(sql);

            // setting parameter
            stmt.setString(1, classid);

            rs = stmt.executeQuery();

            if ( !rs.next() ) {

                rs.close(); //closing ResultSet
                stmt.close(); //closing PreparedStatement

            }

            Teacher teach = new Teacher( rs.getString("teacherid"), rs.getString("classid") );

            rs.close(); //closing ResultSet
            stmt.close(); //closing PreparedStatement
            db.close(); //closing Connection

            return teach;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        } finally {

            try {
                db.close();
            } catch (Exception e) {
                
            }

        }

	} //End of getTeacherByClass

}