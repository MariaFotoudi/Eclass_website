package ismgroup66_java;

import java.sql.*;

/**
 * UserService provides all the necessary methods related to users.
 * In future lesson we will change the code in order to provide data from a Database.
 *  
 * @version 1.0
 */
public class UserService {

    /**
	 * This method is used to authenticate a user.     
	 * 
	 * @param username, String the username
	 * @param password, String the password
	 * @return User, the User Object 
	 * @throws Exception, if the credentials are not valid or an error occurs.
	 */
    public User authenticate(String username, String userpassword) throws Exception {

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE username=? AND userpassword=?;";

        try {
            
            con = db.getConnection();
            stmt = con.prepareStatement(sql);

            // setting parameters
            stmt.setString(1, username);
            stmt.setString(2, userpassword);

            rs = stmt.executeQuery();

            if ( !rs.next() ) {

                throw new Exception("Wrong username or password");

            }

            User user = new User( rs.getString("username"), rs.getString("userpassword") );

            rs.close();
            stmt.close();
            db.close();
            
            return user;

        } catch (Exception e) {
            
            throw new Exception(e.getMessage());

        } finally {

            try {
                db.close();
            } catch (Exception e) {
                
            }

        }

    }
    
} //End of class