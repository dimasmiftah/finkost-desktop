/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.implement;

import edu.finkost.finkostdesktop.error.rencanaException;
import edu.finkost.finkostdesktop.service.rencanaDao;
import edu.finkots.finkostdesktop.entity.rencana;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Freza
 */
public class rencanaDaoImpl implements rencanaDao {
    
    private Connection connection;

         
    private final String insertrencana = "INSERT INTO rencana (nama,nominal,tgl_rencana,status,catatan) VALUES(?,?,?,?,?) ";
    
    private final String updaterencana = "UPDATE rencana SET nama=?,nominal=?,tgl_rencana=?,status=?,catatan=? WHERE ID=?";
    
    private final String deleterencana = "DELETE FROM rencana WHERE ID=?";
    
    private final String getByid = " SELECT * FROM rencana WHERE ID=? ";
    
    private final String getBytgl_rencana= " SELECT * FROM rencana WHERE tgl_rencana=? ";
    
    private final String selectAll = "SELECT * FROM rencana";
    public rencanaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertrencana(rencana rencana) throws rencanaException {
       PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(insertrencana);
        statement.setString(1, rencana.getNama());
        statement.setInt(2, rencana.getNominal());
        statement.setDate(3, (Date) rencana.getTgl_rencana());
        statement.setString(4,rencana.getStatus());
        statement.setString(5, rencana.getCatatan());
               
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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
    public void updaterencana(rencana rencana) throws rencanaException {
                PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false); 
        statement = connection.prepareStatement(updaterencana);
        statement.setString(1, rencana.getNama());
        statement.setInt(2, rencana.getNominal());
        statement.setDate(3, (Date) rencana.getTgl_rencana());
        statement.setString(4,rencana.getStatus());
        statement.setString(5, rencana.getCatatan());
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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
    public void deleterencana(Integer id) throws rencanaException {
          PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(deleterencana);
        statement.setInt(1,id);
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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
    public rencana getrencana(Integer id) throws rencanaException {
     PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(getByid);
        statement.setInt(1,id);
        ResultSet result = statement.executeQuery();
        rencana rencana=null;
        if(result.next()){
            rencana = new rencana();
            rencana.setId(result.getInt("id"));
            rencana.setUid(result.getInt("uid"));
            rencana.setNama(result.getString("nama"));
            rencana.setNominal(result.getInt("nominal"));
            rencana.setTgl_rencana(result.getDate("tgl_rencana"));
            rencana.setStatus(result.getString("status"));
            rencana.setCatatan(result.getString("catatan"));
            rencana.setId_kategori(result.getInt("id_kategori"));
            
        }else{
            throw new rencanaException("pengguna dengan id"+id+"tidak ada");
        }
        connection.commit();
        return rencana;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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
    public List<rencana> selectAllrencana() throws rencanaException {
          Statement statement = null;
        List<rencana> list = new ArrayList<rencana>();
        try{
             connection.setAutoCommit(false);
        statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(selectAll);
        rencana rencana=null;
        while(result.next()){
            rencana.setId(result.getInt("id"));
            rencana.setUid(result.getInt("Uid"));
            rencana.setNama(result.getString("nama"));
            rencana.setNominal(result.getInt("nominal"));
            rencana.setTgl_rencana(result.getDate("tgl_rencana"));
            rencana.setStatus(result.getString("status"));
            rencana.setCatatan(result.getString("catatan"));
            rencana.setId_kategori(result.getInt("id_kategori"));
            list.add(rencana);
        }
        connection.commit();
        return list;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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
    public rencana getrencana(java.util.Date tgl_rencana) throws rencanaException {
       PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(getBytgl_rencana);
        statement.setDate(1, (Date) tgl_rencana);
        ResultSet result = statement.executeQuery();
        rencana rencana=null;
        if(result.next()){
            rencana = new rencana();
            rencana.setId(result.getInt("id"));
            rencana.setUid(result.getInt("uid"));
            rencana.setNama(result.getString("nama"));
            rencana.setNominal(result.getInt("nominal"));
            rencana.setTgl_rencana(result.getDate("tgl_rencana"));
            rencana.setStatus(result.getString("status"));
            rencana.setCatatan(result.getString("catatan"));
            rencana.setId_kategori(result.getInt("id_kategori"));
        }else{
            throw new rencanaException("rencana dengan tanggal"+tgl_rencana+"tidak ada");
        }
        connection.commit();
        return rencana;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new rencanaException(e.getMessage());
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

