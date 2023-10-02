
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDAO {


    public void register(Student student,User user,String[] classid) throws Exception {
			
		DB db=new DB();
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sqlquery="SELECT * FROM users WHERE username=?;";

        String sql1 = "INSERT INTO users(`Username`,`userpassword`) VALUES (?,?);";
		String sql2 = "INSERT INTO Student(`lastname`,`firstname`,`email`,`username`) VALUES (?,?,?,?);";
		String sqlquery2="Select * from studentsclass where classid=?";
		String sql3 = "INSERT INTO studentsclass(`classid`,`username`) VALUES (?,?);";
		String username= user.getUsername();
		

		try{
			con = db.getConnection();
			stmt=con.prepareStatement(sqlquery);
			stmt.setString(1,username);
			rs=stmt.executeQuery();
			if ( rs.next() ) {
                rs.close();
                stmt.close();
                throw new Exception("Sorry, username already registered");
			}
				ResultSet rs1=null;
				String firstname = student.getFirstname();
				String lastname =student.getLastname();
				String email= student.getEmail();
				String password=user.getUserPassword();
				
				PreparedStatement stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1 , username);
				stmt1.setString(2 , password);
				stmt1.executeUpdate();
				stmt1.close();

				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setString(1 , lastname);
				stmt2.setString(2 , firstname);
				stmt2.setString(3, email);
				stmt2.setString(4 , username);
				stmt2.executeUpdate();
				stmt2.close();
				PreparedStatement stmtq= con.prepareStatement(sqlquery2);
				for(int a=0; a <= classid.length;a++){
					stmtq.setString(1,classid[a]);
					rs1=stmtq.executeQuery();
					if (rs1.next()){
						rs1.close();
                		stmt.close();
                		throw new Exception("Sorry, classid already exists");
					}
				}
				PreparedStatement stmt3 = con.prepareStatement(sql3);
				for(int i=0; i <= classid.length;i++){
					stmt3.setString(1, classid[i]);
					stmt3.setString(2, username);
					stmt3.executeUpdate();
				}
			stmt3.close();
			rs.close(); //closing ResultSet
            stmt.close(); //closing PreparedStatement
            db.close(); //closing Connection


		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			try {
                db.close();
            } catch (Exception e) {
				throw new Exception(e.getMessage());
            }
		}

		
		
		
	}//end of register
}