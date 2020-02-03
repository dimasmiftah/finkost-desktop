/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.service;

import edu.finkost.finkostdesktop.error.kategoriException;
import edu.finkots.finkostdesktop.entity.kategori;
import java.util.List;


/**
 *
 * @author Freza
 */
public interface KategoriDao {
    
    public void insertkategori(kategori kategori) throws kategoriException;
    public void updatekategori(kategori kategori) throws kategoriException;
    public void deletekategori(Integer id) throws kategoriException;
    public kategori getkategori(Integer id) throws kategoriException;
    public kategori getkategori(String nama_kategori) throws kategoriException;
    public List<kategori> selectAllkategori() throws kategoriException;
}
