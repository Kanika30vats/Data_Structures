//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int res[] = new int[2];
        int count = 0;
        int maxProfit = 0;
        int maxDeadline = Integer.MIN_VALUE;
        int jobTracker[];
        
        // Finding max deadline.
        for(int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        
        jobTracker = new int[maxDeadline];
        Arrays.fill(jobTracker, -1);
        
        // Sorting in decreasing order of profit.
        Arrays.sort(arr, new MyComparator());
        
        for(int i = 0; i < n; i++) {
            for(int j = arr[i].deadline - 1; j >= 0; j--) {
                if(jobTracker[j] == -1) {
                    jobTracker[j] = arr[i].id;
                    count++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        res[0] = count;
        res[1] = maxProfit;
        return res;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class MyComparator extends Job implements Comparator<Job> {
    MyComparator() {
        super(0, 0, 0);
    }
    
    @Override
    public int compare(Job j1, Job j2) {
        return j2.profit - j1.profit;
    }
}