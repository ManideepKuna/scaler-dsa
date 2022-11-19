package heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solve = solution.solve(new ArrayList<>(Arrays.asList(5, 17, 100, 11)));
        System.out.println(solve);

    }

    public int solve(ArrayList<Integer> A) {

        for(int i = (A.size()/2) - 1; i>=0 ;i--)
        {
            minHeapify(A,i);
        }
        int sol =0;
        while(A.size()>1)
        {
            int rope1 = extractMin(A);
            int rope2 = extractMin(A);
            int sum = rope1 + rope2;
            sol = sol + sum;
            addElement(A,sum);
        }
        return sol;
    }

    public void minHeapify(ArrayList<Integer> arr, Integer i)
    {
        int left = (2*i)+1;
        int right = (2*i)+2;
        int smallest;
        if(left<arr.size() && arr.get(left)<arr.get(i))
        {
            smallest = left;
        }
        else
        {
            smallest = i;
        }
        if(right<arr.size() && arr.get(right)<arr.get(smallest))
        {
            smallest = right;
        }
        if(i != smallest)
        {
            int temp = arr.get(smallest);
            arr.set(smallest,arr.get(i));
            arr.set(i,temp);
            minHeapify(arr,smallest);
        }
    }

    public int extractMin(ArrayList<Integer> arr)
    {
        int min = arr.get(0);
        int temp = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);
        arr.remove(arr.size()-1);
        minHeapify(arr,0);
        return min;
    }

    public void addElement(ArrayList<Integer> arr, Integer ele)
    {
        arr.add(ele);
        int i = arr.size()-1;
        while(arr.get(i)<arr.get(i/2))
        {
            int temp = arr.get(i);
            arr.set(i,arr.get(i/2));
            arr.set(i/2,temp);
            i = i/2;
        }
    }
}
