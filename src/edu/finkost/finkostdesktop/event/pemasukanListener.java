/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.event;

import edu.finkost.finkostdesktop.model.pemasukanmodel;
import edu.finkots.finkostdesktop.entity.transaksi;

/**
 *
 * @author dimas
 */
public interface pemasukanListener {
    public void onChange(pemasukanmodel model);
    
    public void onInsert(transaksi pemasukan);
    
    public void onDelete();
    
    public void onUpdate(transaksi pemasukan);
}
