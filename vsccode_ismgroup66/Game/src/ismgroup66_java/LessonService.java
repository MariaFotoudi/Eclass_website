package ismgroup66_java;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class LessonService {

    public List<Lesson> getLesson(String classid) throws Exception {

        List<Lesson> lesson = new ArrayList<Lesson>();

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM lesson where classid =?";
     
        try {

            con = db.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, classid);

            rs = stmt.executeQuery();

            while ( rs.next() ) {
                Lesson l = new Lesson(rs.getInt("lessonnumber"), rs.getString("classid"), rs.getString("theory"));
                lesson.add(l);
            }

            rs.close();
            stmt.close();
            db.close();

            return lesson;

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