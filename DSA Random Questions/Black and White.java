//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        long ans = 0;
        long mod = (long)1e9 + 7;
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                long ways = computeNoOfWays(N, M, x, y);
                ans += ways;
            }
        }
        return ans%mod;
    }
    
    private static long computeNoOfWays(int N, int M, int x, int y) {
        long noOfways = (N * M) - 1;
        int[] delX = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] delY = {2, 1, -1, -2, -2, -1, 1, 2};
        for(int k = 0; k < 8; k++) {
            int newX = x + delX[k];
            int newY = y + delY[k];
            if(newX >= 0 && newX < N && newY >= 0 && newY < M) {
                noOfways--;
            }
        }
        return noOfways;
    }
}