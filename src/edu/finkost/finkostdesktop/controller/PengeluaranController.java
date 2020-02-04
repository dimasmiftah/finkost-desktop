/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.controller;

import edu.finkost.finkostdesktop.model.pengeluaranmodel;
import edu.finkost.finkostdesktop.view.PengeluaranView;
import javax.swing.JOptionPane;

/**
 *
 * @author dimas
 */
public class PengeluaranController {
    private pengeluaranmodel model;

    public void setModel(pengeluaranmodel model) {
        this.model = model;
    }
    
    public void resetPengeluaran(PengeluaranView view){
        model.resetPengeluaran();
    }
    
    public void insertPengeluaran(PengeluaranView view){
        Integer pengeluaran = Integer.parseInt(view.getPengeluaran_inputTxt().getText());
        Integer kategori = Integer.parseInt(view.getKategoriBox().getItemAt(0));
        String catatan = view.getCatatanTxt().getText();
        
        
        if (pengeluaran<=0) {
            JOptionPane.showMessageDialog(view, "Nominal tidak valid!");
        } else{
            model.setPengeluaran(pengeluaran);
            model.setKategori(kategori);
            model.setCatatan(catatan);
            
            try {
                model.insertPengeluaran();
                JOptionPane.showMessageDialog(view, "Pemasukan berhasil ditambahkan");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi error di database dengan pesan ",throwable.getMessage()});
            }
        }
    }
}
