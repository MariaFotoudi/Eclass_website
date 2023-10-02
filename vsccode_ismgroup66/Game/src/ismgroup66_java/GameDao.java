package ismgroup66_java;

import java.sql.*;


public class GameDao {

    public Game ConnectGame(Lesson lesson) throws Exception{
        DB db=new DB();
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sqlquery="SELECT * FROM Game WHERE lessonnumber=? ;";
      int lessonnumber = lesson.getLessonNum(); /*1**/
        
        
    try{
			con = db.getConnection();
			stmt=con.prepareStatement(sqlquery);
			stmt.setInt(1,lessonnumber);

			rs=stmt.executeQuery();
			if ( !(rs.next()) ) {
                rs.close();
                stmt.close();
                throw new Exception("nyll");
			}

      
			Game game = new Game(rs.getString("gamecode"), rs.getInt("lessonnumber"), rs.getString("words"));
      stmt.close(); //closing PreparedStatement
      db.close(); //closing Connection    
      return game;


		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			try {
                db.close();
            } catch (Exception e) {
				throw new Exception(e.getMessage());
            }
		}

		
		
		
	}



      public void saveStudent(Gamesession gamesession) throws Exception{
        String username = gamesession.getusername();
        Integer points = gamesession.gettotalpoints();
        DB db=new DB();
        Connection con = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs2=null;
        String sql2 = "Select * From Student where username=?;";
        String sql3="UPDATE Student SET sumpoints=? WHERE username=?;";
        try {
          con = db.getConnection();
          stmt2=con.prepareStatement(sql2);
          stmt2.setString(1,username);
          rs2=stmt2.executeQuery();
          if (rs2.next() == false){ /*there is no such student */
              rs2.close();
              stmt2.close();
              throw new Exception("nyll");
            }
            int previous = rs2.getInt("sumpoints");
            int total=previous + points;
            stmt3=con.prepareStatement(sql3);
            stmt3.setInt(1, total);
            stmt3.setString(2, username);
            stmt3.executeUpdate();
            stmt2.close(); //closing PreparedStatement
            stmt3.close();
            rs2.close();
            con.close();
            db.close();
          }catch(Exception e){
            throw new Exception(e.getMessage());
          }finally{
            try {
                      db.close();
                  } catch (Exception e) {
              throw new Exception(e.getMessage());
                  }
          }

      }
  
      
}