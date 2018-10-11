import java.sql.*;
import java.util.ArrayList;

public class PlaceControl {
    private Connection connection;
    private ResultSet resultSet = null;
    private Statement stmt = null;

    public PlaceControl(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(Place user){
        boolean addResult = false;
        try {
            Place newUser = user;
            String sqlText = "INSERT INTO iqm VALUES (?,?,?,?)";
            PreparedStatement prepare = connection.prepareStatement(sqlText);
            prepare.setString(1,newUser.getName());
            prepare.setString(2,newUser.getFirstname());
            prepare.setString(3,newUser.getLastname());
            prepare.setString(4,newUser.getOld());

            if (prepare.executeUpdate() == 1){
                addResult = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return addResult;
    }


    public ArrayList<Place> readUser(){ // Review User //
        ArrayList<Place> usersArray = new ArrayList<>();
        Place user = null;
        try{
            stmt = connection.createStatement();
            String query = "SELECT * FROM iqm order by old asc";
            resultSet = stmt.executeQuery(query);
            resultSet.beforeFirst();
            while (resultSet.next()){
                user = new Place();
                user.setName(resultSet.getString(1));
                user.setFirstname(resultSet.getString(2));
                user.setLastname(resultSet.getString(3));
                user.setOld(resultSet.getString(4));
                usersArray.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return usersArray;
    }


    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
