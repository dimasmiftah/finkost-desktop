/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.controller;

import edu.finkost.finkostdesktop.model.tagihanmodel;
import edu.finkost.finkostdesktop.view.TagihanView;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dimas
 */
public class RencanaController {
    private tagihanmodel model;

    public void setModel(tagihanmodel model) {
        this.model = model;
    }
    
    public void resetRencana(TagihanView view){
        model.resetTagihan();
    }
    
    public void insertRencana(TagihanView view){
        Integer tagihan = Integer.parseInt(view.getTxttagihan_input().getText());
        Integer kategori = Integer.parseInt(view.getCategoriBox().getItemAt(0));
        String catatan = view.getTxtcatatan_tagihan().getText();
        Date tanggal = view.getDate_tagihan().getDate();
        
        
        if (tagihan<=0) {
            JOptionPane.showMessageDialog(view, "Nominal tidak valid!");
        } else{
            model.setNominal(tagihan);
            model.setKategori(kategori);
            model.setCatatan(catatan);
            model.setTgl_tagihan(tanggal);
            
            try {
                model.insertTagihan();
                JOptionPane.showMessageDialog(view, "Pemasukan berhasil ditambahkan");
                model.resetTagihan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi error di database dengan pesan ",throwable.getMessage()});
            }
        }
    }
}
