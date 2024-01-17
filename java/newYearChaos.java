// https://www.hackerrank.com/challenges/new-year-chaos

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int count = q.size();
        boolean success = true;
        int minBrides = 0;
        // int searchNum = count - 1;
        for (int i = count - 1; i>=0; i--) {
            int searchNum = i + 1;
            if (q.get(i) == searchNum) {
                // ok
            }
            else if (i > 0 && q.get(i - 1) == searchNum) {
                swap(q, i-1, i);
                minBrides++;
                // printArray(q, minBrides);
            }
            else if (i > 1 && q.get(i - 2) == searchNum) {
                swap(q, i-2, i-1);
                swap(q, i-1, i);
                minBrides += 2;
                // printArray(q, minBrides);
            } else {
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println(String.valueOf(minBrides));
        } else {
            System.out.println("Too chaotic");
        }
    }
    
    private static void printArray(List<Integer> arr, int minBride) {
        System.out.print(minBride + ": ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    private static void swap(List<Integer> arr, int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
