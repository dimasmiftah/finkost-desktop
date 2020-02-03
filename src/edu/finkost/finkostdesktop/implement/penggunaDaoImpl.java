/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.implement;
import edu.finkost.finkostdesktop.error.kategoriException;
import edu.finkost.finkostdesktop.error.penggunaException;
import edu.finkost.finkostdesktop.service.penggunaDao;
import edu.finkots.finkostdesktop.entity.pengguna;
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
public class penggunaDaoImpl implements penggunaDao{
    
     private Connection connection;
     
     private final String insertpengguna = "INSERT INTO pengguna (fullname,username,password) VALUES(?,?,?) ";
    
    private final String updatepengguna = "UPDATE pengguna SET fullname=?,username=?,password=?, WHERE ID=?";
    
    private final String deletepengguna = "DELETE FROM pengguna WHERE ID=?";
    
    private final String getByUid = " SELECT * FROM pengguna WHERE ID=? ";
    
    private final String getByuser_name= " SELECT * FROM kategori WHERE user_name=? ";
    
    private final String selectAll = "SELECT * FROM kategori";
    public penggunaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertpengguna(pengguna pengguna) throws penggunaException {
               PreparedStatement statement = null;
        try{
          connection.setAutoCommit(false);
        statement = connection.prepareStatement(insertpengguna);
        statement.setString(1, pengguna.getFullname());
        statement.setString(2, pengguna.getUsername());
        statement.setString(3, pengguna.getPassword());
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
    public void updatepengguna(pengguna pengguna) throws penggunaException {
                PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false); 
        statement = connection.prepareStatement(updatepengguna);
        statement.setString(1, pengguna.getFullname());
        statement.setString(2, pengguna.getUsername());
        statement.setString(3, pengguna.getPassword());
        statement.setInt(4,pengguna.getUid());
        statement.executeUpdate();
        connection.commit();
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
    public void deletepengguna(Integer Uid) throws penggunaException {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(deletepengguna);
        statement.setInt(1,Uid);
        statement.executeUpdate();
        
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
    public pengguna getpengguna(Integer Uid) throws penggunaException {
                    PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(getByUid);
        statement.setInt(1,Uid);
        ResultSet result = statement.executeQuery();
        pengguna pengguna=null;
        if(result.next()){
            pengguna = new pengguna();
            pengguna.setUid(result.getInt("Uid"));
            pengguna.setFullname(result.getString("fullname"));
            pengguna.setUsername(result.getString("username"));
            pengguna.setPassword(result.getString("password"));
        }else{
            throw new penggunaException("pengguna dengan id"+Uid+"tidak ada");
        }
        connection.commit();
        return pengguna;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
    public pengguna getpengguna(String user_name) throws penggunaException {
               PreparedStatement statement = null;
        try{
             connection.setAutoCommit(false);
        statement = connection.prepareStatement(getByuser_name);
        statement.setString(1,user_name);
        ResultSet result = statement.executeQuery();
        pengguna pengguna=null;
        if(result.next()){
            pengguna = new pengguna();
            pengguna.setUid(result.getInt("Uid"));
            pengguna.setFullname(result.getString("fullname"));
            pengguna.setUsername(result.getString("username"));
            pengguna.setPassword(result.getString("password"));
        }else{
            throw new penggunaException("Kategori dengan nama_kategori"+user_name+"tidak ada");
        }
        connection.commit();
        return pengguna;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
    public List<pengguna> selectAllpengguna() throws penggunaException {
        Statement statement = null;
        List<pengguna> list = new ArrayList<pengguna>();
        try{
             connection.setAutoCommit(false);
        statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(selectAll);
        pengguna pengguna=null;
        while(result.next()){
            pengguna.setUid(result.getInt("Uid"));
            pengguna.setFullname(result.getString("fullname"));
            pengguna.setUsername(result.getString("username"));
            pengguna.setPassword(result.getString("password"));
            list.add(pengguna);
        }
        connection.commit();
        return list;
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }
        
            throw new penggunaException(e.getMessage());
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
