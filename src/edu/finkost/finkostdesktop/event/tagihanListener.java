/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.event;

import edu.finkost.finkostdesktop.model.tagihanmodel;
import edu.finkots.finkostdesktop.entity.rencana;

/**
 *
 * @author dimas
 */
public interface tagihanListener {
    public void onChange(tagihanmodel model);
    
    public void onInsert(rencana rencana);
    
    public void onDelete();
    
    public void onUpdate(rencana rencana);
}
