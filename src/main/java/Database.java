import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    Connection connect = null;



    public Connection openDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connect == null) {
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/placeiqm?"
                        + "user=root&password=root");
            }
            if (connect != null) {
                System.out.println("Connect to database!!!");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.connect;
    }

    public void closeDatabase() {
        try {
            this.connect.close();
            connect = null;
            System.out.println("Close DBConnector!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
