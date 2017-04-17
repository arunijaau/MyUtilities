/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.jaau.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton utility class to simplify managing and using dates and times according to new 
 * Java Date/Time API(Java JDK 8)
 * @author Aruni Jayasooriya
 * @version 1.00
 * @since 1.8
 */
public class DateUtilities {

    private static DateUtilities instance;

    /**
     * An enumeration of format patterns for a date.
     */
    public enum FormatPattern {

        DEFAULT("MMM d yyyy hh:mm"),
        DATEONLY("MM-dd-yyyy"),
        LONGDATE("MM dd yyyy hh:mm:ss a");

        private final String pattern;

        FormatPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return this.pattern;
        }
    }

    private DateUtilities() {
    }
    /**
     * Singleton support.
     * @return only one and only one global instance.
     */
    public static DateUtilities getInstance() {
        if (instance == null) {
            instance = new DateUtilities();
        }
        return instance;
    }

    /**
     * Format a <code>Date</code> according to the default pattern.
     * @param date - a <code>Date</code> object.
     * @return a date formatted according to the default format pattern. 
     * @throws IllegalArgumentException if date or format pattern is null.
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        return this.toString(date, FormatPattern.DEFAULT);

    }

    /**
     * Format a <code>Date</code> according to a given pattern.
     * @param date - a <code>Date</code> object.
     * @param pattern - an enum representing a <code>FormatPattern</code> .
     * @return a date formatted according to the specified pattern.
     * @throws IllegalArgumentException if date or format pattern is null.
     */
    public String toString(LocalDateTime date, FormatPattern pattern) throws IllegalArgumentException {     
        return this.toString(date, pattern.getPattern());
        
    }

    /**
     * Format a <code>Date</code> according to a given pattern.
     * @param date - a <code>Date</code> object.
     * @param pattern - a <code>String</code> of required pattern.
     * @return a date formatted according to the pattern given.
     * @throws IllegalArgumentException if date or format pattern is null or format pattern is empty.
     */
    public String toString(LocalDateTime date, String pattern)  throws IllegalArgumentException {
        if (date == null || pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Date or pattern provided should not be null.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedString = date.format(formatter);
        return formattedString;
    }
    
}

