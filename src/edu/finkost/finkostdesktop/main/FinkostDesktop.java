package edu.finkost.finkostdesktop.main;

import edu.finkost.finkostdesktop.error.kategoriException;
import edu.finkost.finkostdesktop.error.rencanaException;
import edu.finkost.finkostdesktop.service.KategoriDao;
import edu.finkost.finkostdesktop.service.rencanaDao;
import edu.finkost.finkostdesktop.service.transaksiDao;
import edu.finkost.finkostdesktop.view.MainView;
import edu.finkots.finkostdesktop.database.finkostdatabase;
import edu.finkots.finkostdesktop.entity.kategori;
import edu.finkots.finkostdesktop.entity.rencana;
import java.sql.SQLException;
import java.util.Date;

public class FinkostDesktop {

    public static void main(String[] args) throws SQLException,rencanaException {
  
       MainView main = new MainView();
       main.setVisible(true);
       finkostdatabase.getConnection();
    }
    
}
