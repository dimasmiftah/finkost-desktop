/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.service;

import edu.finkost.finkostdesktop.error.rencanaException;
import edu.finkots.finkostdesktop.entity.rencana;
import java.util.List;

/**
 *
 * @author Freza
 */
public interface rencanaDao {
    public void insertrencana(rencana rencana) throws rencanaException;
    public void updaterencana(rencana rencana) throws rencanaException;
    public void deleterencana(Integer id) throws rencanaException;
    public rencana getrencana(Integer id) throws rencanaException;
    public rencana getrencana(java.util.Date tgl_rencana) throws rencanaException;
    public List<rencana> selectAllrencana() throws rencanaException;   
}
