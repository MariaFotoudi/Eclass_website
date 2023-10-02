package ismgroup66_java;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ClassesService {

    public List<Classes> getClasses(String username) throws Exception {
        List<Classes> clas = new ArrayList<Classes>();

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT classid FROM studentclasses WHERE username=?;";

        try {
            
            con = db.getConnection();
            stmt = con.prepareStatement(sql);

            // setting parameter
            stmt.setString(1, username);

            rs = stmt.executeQuery();

            while ( rs.next() ) {

                clas.add(new Classes( rs.getString("classid"), rs.getString("username") ) );

            }

            rs.close(); //closing ResultSet
            stmt.close(); //closing PreparedStatement
            db.close(); //closing Connection

            return clas;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        } finally {

            try {
                db.close();
            } catch (Exception e) {
                
            }

        }

	} //End of getClasses





} // End of class

