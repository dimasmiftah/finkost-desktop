/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.model;

import java.util.Date;

/**
 *
 * @author Freza
 */
public class tagihanmodel {
    private int tagihan;
    private String kategori,catatan;
    private java.util.Date tgl_tagihan;

    public int getTagihan() {
        return tagihan;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Date getTgl_tagihan() {
        return tgl_tagihan;
    }

    public void setTgl_tagihan(Date tgl_tagihan) {
        this.tgl_tagihan = tgl_tagihan;
    }
    
}
