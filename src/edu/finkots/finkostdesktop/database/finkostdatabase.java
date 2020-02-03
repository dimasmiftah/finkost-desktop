 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkots.finkostdesktop.database;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.finkost.finkostdesktop.implement.kategoriDaoImpl;
import edu.finkost.finkostdesktop.implement.penggunaDaoImpl;
import edu.finkost.finkostdesktop.implement.rencanaDaoImpl;
import edu.finkost.finkostdesktop.implement.transaksiDaoImpl;
import edu.finkost.finkostdesktop.service.KategoriDao;
import edu.finkost.finkostdesktop.service.penggunaDao;
import edu.finkost.finkostdesktop.service.rencanaDao;
import edu.finkost.finkostdesktop.service.transaksiDao;
import java.sql.SQLException;

/**
 *
 * @author Freza
 */
public class finkostdatabase {
    private static java.sql.Connection connection;
    private static KategoriDao kategroiDao;
    private static penggunaDao penggunaDao;
    private static rencanaDao rencanaDao;
    private static transaksiDao transaksiDao;
    public static Connection getConnection() throws SQLException{
    
        if(connection==null){
            
           MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/dbfinkost");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
  public static KategoriDao getKategoriDao() throws SQLException{
        
      if(kategroiDao==null){
          kategroiDao = new kategoriDaoImpl(getConnection());
      
      }
      return kategroiDao;

}
      
  public static penggunaDao getpenggunaDao() throws SQLException{
        
      if(penggunaDao==null){
          penggunaDao = new penggunaDaoImpl(getConnection());
      
      }
      return penggunaDao;

}
  
   public static rencanaDao getrencanaDao() throws SQLException{
        
      if(rencanaDao==null){
          rencanaDao = new rencanaDaoImpl(getConnection());
      
      }
      return rencanaDao;

}
  
    public static transaksiDao gettransaksiDao() throws SQLException{
        
      if(transaksiDao==null){
          transaksiDao = new transaksiDaoImpl(getConnection());
      
      }
      return transaksiDao;

}
  
  
}
