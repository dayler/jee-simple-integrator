/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parse and give format for the dates.
 * 
 * @author asalazar
 */
public enum DateFormatter {

    /**
     * Date formatter for 'yyyy-MM-dd'.
     */
    SHORT("yyyy-MM-dd"), 

    /**
     * Date formatter for 'yyyy-MM-dd HH:mm:ss'.
     */
    LONG("yyyy-MM-dd HH:mm:ss");

    /**
     * Date formatter, provide the strategy to parse or format Dates.
     */
    private SimpleDateFormat formatter;

    /**
     * Datefromatter constructor. Initialize the formatter with its pattern.
     * 
     * @param pattern Date time pattern.
     */
    private DateFormatter(String pattern) {
        formatter = new SimpleDateFormat(pattern);
    }

    /**
     * Format date time in its string representation.
     * 
     * @param date Date time to format.
     * 
     * @return String representation of the date time. Return 'empty string ' if the date time is null.
     */
    public String format(Date date) {
        if (date != null) {
            return formatter.format(date);
        } else {
            return StringHelper.EMPTY;
        }
    }

    /**
     * Get date time from its string representation.
     * 
     * @param strDate String date representation to parse.
     * 
     * @return Date time from its string representation. Returns null if the string cannot be parsed.
     */
    public Date parse(String strDate) {
        if (StringHelper.isBlank(strDate)) {
            return null;
        }

        Date result = null;

        try {
            result = formatter.parse(strDate);
        } catch (ParseException ex) {
            // No op
        }

        return result;
    }
}
