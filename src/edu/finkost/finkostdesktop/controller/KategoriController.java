/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.controller;

import edu.finkost.finkostdesktop.model.kategorimodel;
import edu.finkost.finkostdesktop.view.KategoriView;
import javax.swing.JOptionPane;

/**
 *
 * @author dimas
 */
public class KategoriController {
    private kategorimodel model;

    public void setModel(kategorimodel model) {
        this.model = model;
    }
    
    public void resetKategori(KategoriView view){
        model.resetKategori();
    }
    
    public void insertKategori(KategoriView view){
        String nama = view.getTxtkategori().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama kategori harus diisi!");
        } else if(nama.length()>25){
            JOptionPane.showMessageDialog(view, "Nama kategori tidak boleh lebih dari 25 karakter!");
        } else{
            model.setNama_kategori(nama);
            
            try {
                model.insertKategori();
                JOptionPane.showMessageDialog(view, "Kategori berhasil ditambahkan");
                model.resetKategori();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi error di database dengan pesan ",throwable.getMessage()});
            }
        }
    }
}
