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
public class penggunaException extends Exception {

    /**
     * Creates a new instance of <code>penggunaException</code> without detail
     * message.
     */
    public penggunaException() {
    }

    /**
     * Constructs an instance of <code>penggunaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public penggunaException(String msg) {
        super(msg);
    }
}
