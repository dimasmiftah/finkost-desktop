/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.event;

import edu.finkost.finkostdesktop.model.kategorimodel;
import edu.finkots.finkostdesktop.entity.kategori;

/**
 *
 * @author Freza
 */
public interface kategoriListener {
    public void onChange(kategorimodel model);
    
    public void onInsert(kategori kategori);
    
    public void onDelete();
    
    public void onUpdate(kategori kategori);
}
