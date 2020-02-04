/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.model;

import edu.finkost.finkostdesktop.error.kategoriException;
import edu.finkost.finkostdesktop.event.kategoriListener;
import edu.finkost.finkostdesktop.service.KategoriDao;
import edu.finkots.finkostdesktop.database.finkostdatabase;
import edu.finkots.finkostdesktop.entity.kategori;
import java.sql.SQLException;

/**
 *
 * @author Freza
 */
public class kategorimodel {
    private Integer id;
    private String nama_kategori;

    private kategoriListener listener;

    public kategoriListener getListener() {
        return listener;
    }

    public void setListener(kategoriListener listener) {
        this.listener = listener;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
        fireOnChange();
    }
     
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(kategori kategori){
        if (listener!=null) {
            listener.onInsert(kategori);
        }
    }
    
    protected void fireOnUpdate(kategori kategori){
        if (listener!=null) {
            listener.onUpdate(kategori);
        }
    }
    
    protected void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertKategori() throws SQLException, kategoriException{
        KategoriDao dao = finkostdatabase.getKategoriDao();
        kategori kategori = new kategori();
        kategori.setNama_kategori(nama_kategori);
        
        dao.insertkategori(kategori);
        fireOnInsert(kategori);
    }
    
    public void updateKategori() throws SQLException, kategoriException{
        KategoriDao dao = finkostdatabase.getKategoriDao();
        kategori kategori = new kategori();
        kategori.setNama_kategori(nama_kategori);
        kategori.setId(id);
        
        dao.updatekategori(kategori);
        fireOnInsert(kategori);
    }
    
    public void deleteKategori() throws SQLException, kategoriException{
        KategoriDao dao = finkostdatabase.getKategoriDao();
        dao.deletekategori(id);
        fireOnDelete();
    }
    
    public void resetKategori(){
        setId(0);
        setNama_kategori("");
    }
}


