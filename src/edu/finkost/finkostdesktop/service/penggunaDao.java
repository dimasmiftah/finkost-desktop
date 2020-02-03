/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.service;

import edu.finkost.finkostdesktop.error.penggunaException;
import edu.finkots.finkostdesktop.entity.pengguna;
import java.util.List;

/**
 *
 * @author Freza
 */
public interface penggunaDao {
   public void insertpengguna(pengguna pengguna) throws penggunaException;
    public void updatepengguna(pengguna pengguna) throws penggunaException;
    public void deletepengguna(Integer Uid) throws penggunaException;
    public pengguna getpengguna(Integer Uid) throws penggunaException;
    public pengguna getpengguna(String user_name) throws penggunaException;
    public List<pengguna> selectAllpengguna() throws penggunaException;   
}
