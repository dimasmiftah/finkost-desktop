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
public class transaksiException extends Exception {

    /**
     * Creates a new instance of <code>transaksiException</code> without detail
     * message.
     */
    public transaksiException() {
    }

    /**
     * Constructs an instance of <code>transaksiException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public transaksiException(String msg) {
        super(msg);
    }
}
