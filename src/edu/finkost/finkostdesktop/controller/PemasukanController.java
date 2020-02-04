/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.controller;

import edu.finkost.finkostdesktop.model.pemasukanmodel;
import edu.finkost.finkostdesktop.view.PemasukanView;
import javax.swing.JOptionPane;

/**
 *
 * @author dimas
 */
public class PemasukanController {
    private pemasukanmodel model;

    public void setModel(pemasukanmodel model) {
        this.model = model;
    }
    
    public void resetPemasukan(PemasukanView view){
        model.resetPemasukan();
    }
    
    public void insertPemasukan(PemasukanView view){
        Integer pemasukan = Integer.parseInt(view.getPemasukan_inputTxt().getText());
        Integer kategori = Integer.parseInt(view.getKategoriBox().getItemAt(0));
        String catatan = view.getCatatanTxt().getText();
        
        
        if (pemasukan<=0) {
            JOptionPane.showMessageDialog(view, "Nominal tidak valid!");
        } else{
            model.setPemasukan(pemasukan);
            model.setKategori(kategori);
            model.setCatatan(catatan);
            
            try {
                model.insertPemasukan();
                JOptionPane.showMessageDialog(view, "Pemasukan berhasil ditambahkan");
                model.resetPemasukan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi error di database dengan pesan ",throwable.getMessage()});
            }
        }
    }
}
