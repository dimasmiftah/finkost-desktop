package edu.finkost.finkostdesktop.main;

import edu.finkots.finkostdesktop.database.finkostdatabase;
import java.sql.SQLException;

public class FinkostDesktop {

    public static void main(String[] args) throws SQLException {
        finkostdatabase.getConnection();
    }
    
}
