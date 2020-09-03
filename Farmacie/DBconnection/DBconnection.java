package Farmacie.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

        private static DBconnection db = null;
        private String URL = "jdbc:mysql://127.0.0.1:3306/farmacie";
        private String USER = "root";

        private DBconnection(){
        }

        public static DBconnection get_instance(){
            if(db == null){
                db = new DBconnection();
            }
            return db;
        }

        public Connection connection() throws SQLException {
            Connection con = DriverManager.getConnection(URL,USER,"nubeauapaplata");
            return con;
        }
}
