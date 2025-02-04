package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

	private static final Logger LOGGER = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        // Log messages at different levels
        LOGGER.severe("This is a severe message.");
        LOGGER.warning("This is a warning message.");
        LOGGER.info("This is an info message.");
        LOGGER.config("This is a config message.");
        LOGGER.fine("This is a fine message.");
        LOGGER.finer("This is a finer message.");
        LOGGER.finest("This is the finest message.");

        
        // Log an exception
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred", e);
        }
    }
}
