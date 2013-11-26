/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.helper;

/**
 *
 * @author asalazar
 */
public class DoubleHelper {

    public static Double tryParse(String rawValue) {
        if (StringHelper.isBlank(rawValue))
        {
            // No Parseable.
            return null;
        }

        try {
            // Try to parse.
            return Double.parseDouble(rawValue);
        }
        catch (NumberFormatException ex) {
            // No Parseable.
            return null;
        }
    }
}
