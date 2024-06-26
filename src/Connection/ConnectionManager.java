
package Connection;

import java.sql.DriverManager;

public class ConnectionManager {
    private java.sql.Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_caferinai"; //nama database
    private String username = "root"; // user name DMBS
    private String password = ""; // password DMBS

    public java.sql.Connection logOn(){
 try {
  //Buka JDBC Driver
   Class.forName( driver ).newInstance();
   //object Connection
   con = DriverManager.getConnection(url,username,password );
        }
   catch(Exception ex){
   ex.printStackTrace();
        }
   return con;
    }
   public void logOff(){
   try {
   //Tutup Koneksi
   con.close();
    }
   catch(Exception ex){ 
    ex.printStackTrace();
        }
    }
}



