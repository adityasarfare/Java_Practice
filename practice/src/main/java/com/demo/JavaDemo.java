package com.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaDemo  {



	 public static void main(String[] args) {
	        // Creating a daemon thread
	        Thread daemonThread = new Thread(new DaemonTask());
	        
	        // Setting the thread as a daemon thread
	        daemonThread.setDaemon(true);
	        
	        // Starting the daemon thread
	        daemonThread.start();
	        
	        // Main thread
	        System.out.println("Main thread is running...");

	        // Sleep for some time to allow the daemon thread to do its work
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Main thread is exiting.");
	    }

	    static class DaemonTask implements Runnable {
	        @Override
	        public void run() {
	            while (true) {
	                // Daemon thread's task (infinite loop in this example)
	                System.out.println("Daemon thread is running...");

	                // Sleep for a short time to simulate some work
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}
	




