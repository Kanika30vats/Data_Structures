//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int res = 1;
        Activity[] activity = new Activity[n];
        
        for(int i = 0; i < n; i++) {
            activity[i] = new Activity(start[i], end[i]);
        }
        
        Arrays.sort(activity, new MyComparator());
        
        Activity prev = activity[0];
        for(int i = 1; i < activity.length; i++) {
            if(prev.end < activity[i].start) {
                res++;
                prev = activity[i];
            }
        }
        
        return res;
    }
}

class Activity{
    int start;
    int end;
    
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyComparator implements Comparator<Activity> {
    
    @Override
    public int compare(Activity activity1, Activity activity2) {
        return activity1.end - activity2.end;
    }
}