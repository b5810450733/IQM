import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Connection connection = db.openDatabase();
        PlaceControl placeControl = new PlaceControl(connection);

//        Place p = new Place("ICEKARN","LOVE","Forever",null);
//
//        System.out.println(placeControl.addUser(p));

        ArrayList<Place> userList = placeControl.readUser();
        for (Place i: userList) {
//            if (i.getOld() != null){
                System.out.println(i);
            }
        //}
    }
}
