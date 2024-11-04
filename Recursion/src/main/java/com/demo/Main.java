package com.demo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        while ((line = in.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length != 2) {
                System.out.println("NULL");
                continue;
            }

            String[] numbersStr = parts[0].split(",");
            int targetSum = Integer.parseInt(parts[1].trim());
            List<Integer> numbers = new ArrayList<>();
            for (String num : numbersStr) {
                numbers.add(Integer.parseInt(num.trim()));
            }

            // Find unique pairs that sum to targetSum
            List<String> resultPairs = new ArrayList<>();
            Set<Integer> seenNumbers = new HashSet<>();
            for (int num : numbers) {
                int complement = targetSum - num;
                if (seenNumbers.contains(complement)) {
                    String pair = Math.min(num, complement) + "," + Math.max(num, complement);
                    if (!resultPairs.contains(pair)) {
                        resultPairs.add(pair);
                    }
                }
                seenNumbers.add(num);
            }

            if (resultPairs.isEmpty()) {
                System.out.println("NULL");
            } else {
                Collections.sort(resultPairs);
                System.out.println(String.join(";", resultPairs));
            }
        }
    }
}