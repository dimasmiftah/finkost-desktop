/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.model;

import edu.finkost.finkostdesktop.error.transaksiException;
import edu.finkost.finkostdesktop.event.pemasukanListener;
import edu.finkost.finkostdesktop.service.transaksiDao;
import edu.finkots.finkostdesktop.database.finkostdatabase;
import edu.finkots.finkostdesktop.entity.transaksi;
import java.sql.SQLException;

/**
 *
 * @author Freza
 */
public class pemasukanmodel {
   private int id,pemasukan,kategori;
   private String catatan;
   
   private pemasukanListener listener;

    public pemasukanListener getListener() {
        return listener;
    }

    public void setListener(pemasukanListener listener) {
        this.listener = listener;
    }

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
        fireOnChange();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public Integer getKategori() {
        return kategori;
    }

    public void setKategori(Integer kategori) {
        this.kategori = kategori;
        fireOnChange();
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
        fireOnChange();
    }
   
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(transaksi transaksi){
        if (listener!=null) {
            listener.onInsert(transaksi);
        }
    }
    
    protected void fireOnUpdate(transaksi transaksi){
        if (listener!=null) {
            listener.onUpdate(transaksi);
        }
    }
    
    protected void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertPemasukan() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        transaksi transaksi = new transaksi();
        transaksi.setNominal(pemasukan);
//        transaksi.setId_kategori(kategori);
        transaksi.setCatatan(catatan);
        
        dao.insertransaksi(transaksi);
        fireOnInsert(transaksi);
    }
    
    public void updatePemasukan() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        transaksi transaksi = new transaksi();
        transaksi.setNominal(pemasukan);
//        transaksi.setId_kategori(kategori);
        transaksi.setCatatan(catatan);
        transaksi.setId_transaksi(id);
        
        dao.updatetransaksi(transaksi);
        fireOnInsert(transaksi);
    }
    
    public void deletePemasukan() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        dao.deletetransaksi(id);
        fireOnDelete();
    }
    
    public void resetPemasukan(){
        setId(0);
        setCatatan("");
        setKategori(0);
        setPemasukan(0);
    }
}
