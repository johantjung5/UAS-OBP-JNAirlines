import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    static Connection db;
    public Database(){
        try{
            String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/jnairlines";
            String user = "root";
            String pass = "";

            Class.forName(jdbcDriver);
            db = DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
