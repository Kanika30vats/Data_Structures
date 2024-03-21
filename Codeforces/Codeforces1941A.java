package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Codeforces1941A {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCases = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < testCases; i++) {
                // int n = Integer.parseInt(bufferedReader.readLine());
                // int m = Integer.parseInt(bufferedReader.readLine());
                // int k = Integer.parseInt(bufferedReader.readLine());
                String[] input = bufferedReader.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int m = Integer.parseInt(input[1]);
                int k = Integer.parseInt(input[2]);
                String[] arr1Input = bufferedReader.readLine().split(" ");
                int[] arr1 = new int[n];
                for (int j = 0; j < n; j++) {
                    arr1[j] = Integer.parseInt(arr1Input[j]);
                }
                String[] arr2Input = bufferedReader.readLine().split(" ");
                int[] arr2 = new int[m];
                for (int j = 0; j < m; j++) {
                    arr2[j] = Integer.parseInt(arr2Input[j]);
                }

                Solution s = new Solution();
                System.out.println("Ans " + i+1 + " : " + s.solve(arr1, arr2, n, m, k));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Solution {
    public int solve(int[] arr1, int[] arr2, int n, int m, int k) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr1[i] + arr2[j] < k) {
                    count++;
                }
            }
            
        }
        return count;
    }
}
