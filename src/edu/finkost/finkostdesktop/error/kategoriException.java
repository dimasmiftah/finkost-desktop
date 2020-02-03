/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.finkost.finkostdesktop.error;

/**
 *
 * @author Freza
 */
public class kategoriException extends Exception {

    /**
     * Creates a new instance of <code>kategoriException</code> without detail
     * message.
     */
    public kategoriException() {
    }

    /**
     * Constructs an instance of <code>kategoriException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public kategoriException(String msg) {
        super(msg);
    }
}
