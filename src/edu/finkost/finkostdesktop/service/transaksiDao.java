/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.service;


import edu.finkost.finkostdesktop.error.transaksiException;
import edu.finkots.finkostdesktop.entity.transaksi;
import java.util.List;

/**
 *
 * @author Freza
 */
public interface transaksiDao {
    public void insertransaksi(transaksi transaksi) throws transaksiException;
    public void updatetransaksi(transaksi transaksi) throws transaksiException;
    public void deletetransaksi(Integer id_transaksi) throws transaksiException;
    public transaksi gettransaksi(Integer id_transaksi) throws transaksiException;
    public transaksi gettransaksi(java.util.Date tgl_transaksi) throws transaksiException;
    public List<transaksi> selectAlltranskasi() throws transaksiException;   
}
