/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkots.finkostdesktop.entity;

import java.util.Objects;

/**
 *
 * @author Freza
 */
public class transaksi {
    private Integer id_transaksi;
    private Integer uid;
    private Integer id_kategori;
    private Integer uang_sekarang;
    private String jenis_transaksi;

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(Integer id_kategori) {
        this.id_kategori = id_kategori;
    }

    public Integer getUang_sekarang() {
        return uang_sekarang;
    }

    public void setUang_sekarang(Integer uang_sekarang) {
        this.uang_sekarang = uang_sekarang;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_transaksi);
        hash = 97 * hash + Objects.hashCode(this.uid);
        hash = 97 * hash + Objects.hashCode(this.id_kategori);
        hash = 97 * hash + Objects.hashCode(this.uang_sekarang);
        hash = 97 * hash + Objects.hashCode(this.jenis_transaksi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final transaksi other = (transaksi) obj;
        if (!Objects.equals(this.id_transaksi, other.id_transaksi)) {
            return false;
        }
        if (!Objects.equals(this.uid, other.uid)) {
            return false;
        }
        if (!Objects.equals(this.id_kategori, other.id_kategori)) {
            return false;
        }
        if (!Objects.equals(this.uang_sekarang, other.uang_sekarang)) {
            return false;
        }
        return true;
    }
    
}
