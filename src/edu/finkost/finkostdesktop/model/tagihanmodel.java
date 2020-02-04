/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.model;

import edu.finkost.finkostdesktop.error.rencanaException;
import edu.finkost.finkostdesktop.event.tagihanListener;
import edu.finkost.finkostdesktop.service.rencanaDao;
import edu.finkots.finkostdesktop.database.finkostdatabase;
import edu.finkots.finkostdesktop.entity.rencana;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Freza
 */
public class tagihanmodel {
    private int id,nominal,kategori;
    private String nama, catatan;
    private java.util.Date tgl_tagihan;
    
    private tagihanListener listener;

    public tagihanListener getListener() {
        return listener;
    }

    public void setListener(tagihanListener listener) {
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
        fireOnChange();
    }

    public int getKategori() {
        return kategori;
    }

    public void setKategori(int kategori) {
        this.kategori = kategori;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
        fireOnChange();
    }

    public Date getTgl_tagihan() {
        return tgl_tagihan;
    }

    public void setTgl_tagihan(Date tgl_tagihan) {
        this.tgl_tagihan = tgl_tagihan;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(rencana rencana){
        if (listener!=null) {
            listener.onInsert(rencana);
        }
    }
    
    protected void fireOnUpdate(rencana rencana){
        if (listener!=null) {
            listener.onUpdate(rencana);
        }
    }
    
    protected void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertTagihan() throws SQLException, rencanaException{
        rencanaDao dao = finkostdatabase.getrencanaDao();
        rencana rencana = new rencana();
        rencana.setNama(nama);
        rencana.setNominal(nominal);
        rencana.setTgl_rencana(tgl_tagihan);
        rencana.setCatatan(catatan);
        
        dao.insertrencana(rencana);
        fireOnInsert(rencana);
    }
    
    public void updateTagihan() throws SQLException, rencanaException{
        rencanaDao dao = finkostdatabase.getrencanaDao();
        rencana rencana = new rencana();
        rencana.setNama(nama);
        rencana.setNominal(nominal);
        rencana.setTgl_rencana(tgl_tagihan);
        rencana.setCatatan(catatan);
        rencana.setId(id);
        
        dao.updaterencana(rencana);
        fireOnInsert(rencana);
    }
    
    public void deleteTagihan() throws SQLException, rencanaException{
        rencanaDao dao = finkostdatabase.getrencanaDao();
        dao.deleterencana(id);
        fireOnDelete();
    }
    
    public void resetTagihan(){
        setId(0);
        setCatatan("");
        setKategori(0);
        setNominal(0);
        setNama("");
    }
}