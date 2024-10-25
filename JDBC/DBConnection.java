import java.sql.*;

class DBConnection {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "animesh");
    Statement stmt = con.createStatement();
    String sqlq = "INSERT INTO companies VALUES(102,'ABC','XYZ','abc@gmail.com',8628825068)";
    stmt.execute(sqlq);
    // String sel = "select * from companies";
    // ResultSet rs = stmt.executeQuery(sel);
    // while (rs.next()) {
    // int id = rs.getInt("ID");
    // String FName = rs.getString("FirstName");
    // String LName = rs.getString("LastName");
    // System.out.println(id + " " + FName + " " + LName);
    // }
    con.close();
    System.out.println("Data Updated Successfully");
  }
}