public class gameop {
    
    public String getResult() {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/sampleDB";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
        System.out.println("Connection established......");
      //Creating aStatement
        Statement stmt = con.createStatement();
      //Retrieving the data
        ResultSet rs = stmt.executeQuery("select * from Articles");
        int j = 0;
        System.out.println("Contents of the table are: ");
        while(rs.next()) {
            System.out.println(rs.getString("Name"));
            Clob clob = rs.getClob("Article");
            Reader reader = clob.getCharacterStream();
            String filePath = "E:\\Data\\clob_output"+j+".txt";
            FileWriter writer = new FileWriter(filePath);
            int i;
            while ((i = reader.read())!=-1) {
            writer.write(i);
            }
            writer.close();
            System.out.println(filePath);
            j++;
        }
    }
}
