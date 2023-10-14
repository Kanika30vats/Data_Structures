//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        LinkedHashSet<ArrayList<Integer>> res = new LinkedHashSet<>();
        ArrayList<Integer> subset = new ArrayList<>();
        Arrays.sort(arr);
        res.add(subset);
        generateSubsets(0, subset, res, arr, n);
        return new ArrayList<>(res);
    }
    
    private static void generateSubsets(int i, ArrayList<Integer> subset, LinkedHashSet<ArrayList<Integer>> res, int arr[], int n) {
        if(i == n) {
            return;
        }
        
        // Pick element.
        subset.add(arr[i]);
        res.add(new ArrayList<>(subset));
        generateSubsets(i + 1, subset, res, arr, n);
        subset.remove(subset.size() - 1);
        
        // Not pick element.
        while(i + 1 < n && arr[i] == arr[i+1])
            i++;
        generateSubsets(i + 1, subset, res, arr, n);
        
    }
}
