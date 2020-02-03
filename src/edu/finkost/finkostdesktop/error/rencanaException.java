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
public class rencanaException extends Exception {

    /**
     * Creates a new instance of <code>rencanaException</code> without detail
     * message.
     */
    public rencanaException() {
    }

    /**
     * Constructs an instance of <code>rencanaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public rencanaException(String msg) {
        super(msg);
    }
}
