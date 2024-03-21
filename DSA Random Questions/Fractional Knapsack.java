//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        double res = 0;
        
        Arrays.sort(arr, new MyComparator());
        
        for(int i = 0; i < n; i++) {
            if(arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            }
            else {
                res += ((double)W * ((double)(arr[i].value)/(double)(arr[i].weight)));
                break;
            }
        }
        
        return res;
    }
}

class MyComparator extends Item implements Comparator<Item> {
    
    MyComparator() {
        super(0, 0);
    }
    
    // Sorting in decreasing order of pricePerItem.
    @Override
    public int compare(Item k1, Item k2) {
        return (k1.weight * k2.value) - (k1.value * k2.weight);
    }
}