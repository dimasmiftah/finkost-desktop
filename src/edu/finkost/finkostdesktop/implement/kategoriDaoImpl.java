/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.implement;

import edu.finkost.finkostdesktop.error.kategoriException;
import edu.finkost.finkostdesktop.service.KategoriDao;
import edu.finkots.finkostdesktop.entity.kategori;
import java.sql.Connection;
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
public class kategoriDaoImpl implements KategoriDao {

    private Connection connection;

    private final String insertkategori = "INSERT INTO kategori (nama_kategori) VALUES(?) ";
    
    private final String updatekategori = "UPDATE kategori SET nama_kategori=? WHERE ID=?";
    
    private final String deletekategori = "DELETE FROM kategori WHERE ID=?";
    
    private final String getById = " SELECT * FROM kategori WHERE ID=? ";
    
    private final String getBynama_kategori= " SELECT * FROM kategori WHERE nama_kategori=? ";
    
    private final String selectAll = "SELECT * FROM kategori";
    
    public kategoriDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void insertkategori(kategori kategori) throws kategoriException {
        PreparedStatement statement = null;
        try{
        connection.setAutoCommit(false);
            
        statement = connection.prepareStatement(insertkategori);
        statement.setString(1, kategori.getNama_kategori());
        statement.executeUpdate();
        
        connection.commit();
        
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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
    public void updatekategori(kategori kategori) throws kategoriException {
        PreparedStatement statement = null;
        try{
         connection.setAutoCommit(false);    
        statement = connection.prepareStatement(updatekategori);
        statement.setString(1, kategori.getNama_kategori());
        statement.setInt(2,kategori.getId());
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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
    public void deletekategori(Integer id) throws kategoriException {
          PreparedStatement statement = null;
        try{
        connection.setAutoCommit(false);    
        statement = connection.prepareStatement(deletekategori);
        statement.setInt(1,id);
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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

    public kategori getkategori(Integer id) throws kategoriException {
              PreparedStatement statement = null;
        try{
         connection.setAutoCommit(false);    
        statement = connection.prepareStatement(getById);
        statement.setInt(1,id);
        ResultSet result = statement.executeQuery();
        kategori kategori=null;
        if(result.next()){
            kategori = new kategori();
            kategori.setId(result.getInt("id"));
            kategori.setNama_kategori(result.getString("nama_kategori"));
        }else{
            throw new kategoriException("Kategori dengan id"+id+"tidak ada");
        }
        connection.commit();
        return kategori;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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
    public kategori getkategori(String nama_kategori) throws kategoriException {
        PreparedStatement statement = null;
        try{
        connection.setAutoCommit(false);    
        statement = connection.prepareStatement(getBynama_kategori);
        statement.setString(1,nama_kategori);
        ResultSet result = statement.executeQuery();
        kategori kategori=null;
        if(result.next()){
            kategori = new kategori();
            kategori.setId(result.getInt("id"));
            kategori.setNama_kategori(result.getString("nama_kategori"));
        }else{
            throw new kategoriException("Kategori dengan nama_kategori"+nama_kategori+"tidak ada");
        }
        connection.commit();
        return kategori;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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
    public List<kategori> selectAllkategori() throws kategoriException {
        Statement statement = null;
        List<kategori> list = new ArrayList<kategori>();
        try{
         connection.setAutoCommit(false);    
        statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(selectAll);
        kategori kategori=null;
        while(result.next()){
            kategori = new kategori();
            kategori.setId(result.getInt("id"));
            kategori.setNama_kategori(result.getString("nama_kategori"));
            list.add(kategori);
        }
        connection.commit();
        return list;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new kategoriException(e.getMessage());
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
