/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.exception;

/**
 *
 * @author asalazar
 */
public class OperationException extends Exception{

    public OperationException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

        public OperationException(String errorMsg) {
            super(errorMsg);
        }
}
