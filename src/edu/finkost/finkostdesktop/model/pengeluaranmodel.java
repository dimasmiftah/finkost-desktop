/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.model;

import edu.finkost.finkostdesktop.error.transaksiException;
import edu.finkost.finkostdesktop.event.pengeluaranListener;
import edu.finkost.finkostdesktop.service.transaksiDao;
import edu.finkots.finkostdesktop.database.finkostdatabase;
import edu.finkots.finkostdesktop.entity.transaksi;
import java.sql.SQLException;

/**
 *
 * @author Freza
 */
public class pengeluaranmodel {
    private int id, pengeluaran,kategori;
    private String catatan;

    private pengeluaranListener listener;

    public pengeluaranListener getListener() {
        return listener;
    }

    public void setListener(pengeluaranListener listener) {
        this.listener = listener;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
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
    
    public void insertPengeluaran() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        transaksi transaksi = new transaksi();
        transaksi.setNominal(pengeluaran);
//        transaksi.setId_kategori(kategori);
        transaksi.setCatatan(catatan);
        
        dao.insertransaksi(transaksi);
        fireOnInsert(transaksi);
    }
    
    public void updatePengeluaran() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        transaksi transaksi = new transaksi();
        transaksi.setNominal(pengeluaran);
//        transaksi.setId_kategori(kategori);
        transaksi.setCatatan(catatan);
        transaksi.setId_transaksi(id);
        
        dao.updatetransaksi(transaksi);
        fireOnInsert(transaksi);
    }
    
    public void deletePengeluaran() throws SQLException, transaksiException{
        transaksiDao dao = finkostdatabase.gettransaksiDao();
        dao.deletetransaksi(id);
        fireOnDelete();
    }
   
    public void resetPengeluaran(){
        setId(0);
        setCatatan("");
        setKategori(0);
        setPengeluaran(0);
    }
}
