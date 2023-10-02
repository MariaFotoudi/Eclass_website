
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    public Game ConnectGame(Lesson lesson) throws Exception{
        DB db=new DB();
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sqlquery="SELECT * FROM Game WHERE LessonNumber=? AND classid=?;";
        String classid = lesson.
        int lessonnumber = lesson.getLessonNumber();
        try{
			con = db.getConnection();
			stmt=con.prepareStatement(sqlquery);
			stmt.setInt(1,lessonnumber);
      stmt.setString(2,classid);
			rs=stmt.executeQuery();
			if ( !(rs.next()) ) {
                rs.close();
                stmt.close();
                throw new Exception("Sorry, lesson number already registered");
			}

			Game game = new Game(rs.getInt("gamecode"), rs.getInt("lessonnumber"), getLargerString(rs, "words"));
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

		
		
		
	}//end of register

    public static String getLargerString(ResultSet rs, String columnIndex) throws SQLException {

        InputStream in = null;
        int BUFFER_SIZE = 1024;
        try {
          in = rs.getAsciiStream(columnIndex);
          if (in == null) {
            return "";
          }
    
          byte[] arr = new byte[BUFFER_SIZE];
          StringBuffer buffer = new StringBuffer();
          int numRead = in.read(arr);
          while (numRead != -1) {
            buffer.append(new String(arr, 0, numRead));
            numRead = in.read(arr);
          }
          return buffer.toString();
        } catch (Exception e) {
          e.printStackTrace();
          throw new SQLException(e.getMessage());
        }
      }
}