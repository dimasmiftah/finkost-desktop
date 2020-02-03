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
public class kategori {
    
    private Integer id;
    private String nama_kategori ;
    
    
    public kategori(){
    
    }

    public kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nama_kategori);
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
        final kategori other = (kategori) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nama_kategori, other.nama_kategori)) {
            return false;
        }
        return true;
    }
    
}
