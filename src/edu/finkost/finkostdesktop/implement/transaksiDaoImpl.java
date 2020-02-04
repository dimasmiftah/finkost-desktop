/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.implement;
import edu.finkost.finkostdesktop.error.transaksiException;
import edu.finkost.finkostdesktop.service.transaksiDao;
import edu.finkots.finkostdesktop.entity.transaksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freza
 */
public class transaksiDaoImpl implements transaksiDao {
    
    private Connection connection;
         
    private final String inserttransaksi = "INSERT INTO transaksi (nominal,tgl_transaksi,uang_sekarang,catatan,jenis_transaksi) VALUES(?,?,?,?,?) ";
    
    private final String updateransaksi= "UPDATE transaksi SET nominal=?,tgl_transaksi=?,uang_sekarang=?,catatan=?,jenis_transaksi WHERE id_transaksi=?";
    
    private final String deletetransaksi = "DELETE FROM transaksi WHERE id_transaksi=?";
    
    private final String getByid_transaksi= " SELECT * FROM rencana WHERE id_transaksi=? ";
    
    private final String getBytgl_transaksi= " SELECT * FROM rencana WHERE tgl_transaksi=? ";
    
    private final String selectAll = "SELECT * FROM transaksi";

    public transaksiDaoImpl(Connection connection) {
        this.connection = connection;
         
    }

    @Override
    public void insertransaksi(transaksi transaksi) throws transaksiException {
             PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
        statement = connection.prepareStatement(inserttransaksi);
        statement.setInt(1, transaksi.getNominal());
        statement.setDate(2, (Date) transaksi.getTgl_transaksi());
        statement.setInt(3,transaksi.getUang_sekarang());
        statement.setString(4,transaksi.getCatatan());
        statement.setString(5,transaksi.getJenis_transaksi());
               
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    @Override
    public void updatetransaksi(transaksi transaksi) throws transaksiException {
                       PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
        statement = connection.prepareStatement(updateransaksi);
        statement.setInt(1, transaksi.getNominal());
        statement.setDate(2, (Date) transaksi.getTgl_transaksi());
        statement.setInt(3,transaksi.getUang_sekarang());
        statement.setString(4,transaksi.getCatatan());
        statement.setString(5,transaksi.getJenis_transaksi());
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    @Override
    public void deletetransaksi(Integer id_transaksi) throws transaksiException {
                  PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
        statement = connection.prepareStatement(deletetransaksi);
        statement.setInt(1,id_transaksi);
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    @Override
    public transaksi gettransaksi(Integer id_transaksi) throws transaksiException {
       PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
        statement = connection.prepareStatement(getByid_transaksi);
        statement.setInt(1,id_transaksi);
        ResultSet result = statement.executeQuery();
        transaksi transaksi=null;
        if(result.next()){
            transaksi = new transaksi();
            transaksi.setId_transaksi(result.getInt("id"));
            transaksi.setUid(result.getInt("uid"));
            transaksi.setId_kategori(result.getInt("id_kategori"));
            transaksi.setNominal(result.getInt("nominal"));
            transaksi.setTgl_transaksi(result.getDate("tgl_transaksi"));
            transaksi.setUang_sekarang(result.getInt("uang_sekarang"));
            transaksi.setCatatan(result.getString("catatan"));
            transaksi.setJenis_transaksi(result.getString("jenis_transaksi"));
            
        }else{
            throw new transaksiException("transaksi dengan id"+id_transaksi+"tidak ada");
        }
        connection.commit();
        return transaksi;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    @Override
    public transaksi gettransaksi(java.util.Date tgl_transaksi) throws transaksiException {
       PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
        statement = connection.prepareStatement(getBytgl_transaksi);
        statement.setDate(1, (Date) tgl_transaksi);
        ResultSet result = statement.executeQuery();
        transaksi transaksi=null;
        if(result.next()){
            transaksi = new transaksi();
            transaksi.setId_transaksi(result.getInt("id_transaksi"));
            transaksi.setUid(result.getInt("uid"));
            transaksi.setId_kategori(result.getInt("id_kategori"));
            transaksi.setNominal(result.getInt("nominal"));
            transaksi.setTgl_transaksi(result.getDate("tgl_transaksi"));
            transaksi.setCatatan(result.getString("catatan"));
            transaksi.setJenis_transaksi(result.getString("jenis_transaksi"));
        }else{
            throw new transaksiException("transaksi dengan tanggal"+tgl_transaksi+"tidak ada");
        }
        connection.commit();
        return transaksi;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    @Override
    public List<transaksi> selectAlltranskasi() throws transaksiException {
        Statement statement = null;
        List<transaksi> list = new ArrayList<transaksi>();
        try{
            connection.setAutoCommit(false);
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectAll);
        
        transaksi transaksi=null;
        while(result.next()){
            transaksi = new transaksi();
            transaksi.setId_transaksi(result.getInt("id_transaksi"));
            transaksi.setUid(result.getInt("uid"));
            transaksi.setId_kategori(result.getInt("id_kategori"));
            transaksi.setNominal(result.getInt("nominal"));
            transaksi.setTgl_transaksi(result.getDate("tgl_transaksi"));
            transaksi.setCatatan(result.getString("catatan"));
            transaksi.setJenis_transaksi(result.getString("jenis_transaksi"));
            list.add(transaksi);
        }
        connection.commit();
        return list;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new transaksiException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
             try {
                statement.close();
            } catch (Exception e) {
            }
            }
        
        } 
    }

    
}
