


import java.sql.*;
public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost/restaurant";//database url
    private static final String USER = "root";                          //user name
    private static final String PASSWORD = "";                       // password of the user account
    private static Connection con = null;
    private static Statement st = null;
    private static PreparedStatement stPr=null;
    private String updateTableSql= "UPDATE foods SET count = ? WHERE food = ?";
    
    
    public static Connection getConnection() throws SQLException{
        con =DriverManager.getConnection(DB_URL, USER, PASSWORD);
        st = con.createStatement();
        return con;
    }
    public static Statement getStatement(){
        return st;
    }
    public static void update(String cfood,int ccount) throws SQLException{
        DBConnection db= new DBConnection();
        stPr=db.getPrStatement();
        stPr.setInt(1, ccount);
        stPr.setString(2, cfood);
        stPr.executeUpdate();
        
    }
    public PreparedStatement getPrStatement() throws SQLException{
        stPr = con.prepareStatement(updateTableSql);
        return stPr;
    }
    
    
}
