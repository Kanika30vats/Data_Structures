//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int res = 1;
        Meeting meeting[] = new Meeting[n];
        
        for(int i = 0; i < n; i++) {
            meeting[i] = new Meeting(start[i], end[i]);
        }
        
        Arrays.sort(meeting, new MyComparator());
        
        Meeting prev = meeting[0];
        
        for(int i = 1; i < meeting.length; i++) {
            if(prev.end < meeting[i].start) {
                res++;
                prev = meeting[i];
            }
        }
        
        return res;
    }
    
}

class Meeting {
    int start;
    int end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
    
class MyComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        return m1.end - m2.end;
    }
}
