package heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class MagiciansAndChocolates {

    public static void main(String[] args) {
        MagiciansAndChocolates magiciansAndChocolates = new MagiciansAndChocolates();
        int nchoc = magiciansAndChocolates.nchoc(10, new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483646)));
        System.out.println(nchoc);

    }

    public int nchoc(int A, ArrayList<Integer> B) {
        int sol=0;
        for(int i=B.size()/2-1;i>=0;i--)
        {
            maxHeapify(B,i);
        }
        while(A!=0)
        {
            int val = extraxtMax(B);
            sol = sol+val;
            val = val/2;
            insert(B,val);
            A--;
        }
        return sol;
    }

    public void insert(ArrayList<Integer> arr, int ele)
    {
        arr.add(ele);
        int index = arr.size()-1;
        while(index>0 && arr.get((index-1)/2)<arr.get(index))
        {
            int temp = arr.get(index);
            arr.set(index,arr.get((index-1)/2));
            arr.set((index-1)/2,temp);
            index = (index-1)/2;
        }
    }

    public int extraxtMax(ArrayList<Integer> arr)
    {
        int ele = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        maxHeapify(arr,0);
        return ele;
    }

    public void maxHeapify(ArrayList<Integer> arr, int index)
    {
        int left = 2*index+1;
        int right = 2*index+2;
        int largest;
        if(left<arr.size() && arr.get(left)>arr.get(index))
        {
            largest = left;
        }
        else
        {
            largest = index;
        }
        if(right<arr.size() && arr.get(right)>arr.get(largest))
        {
            largest = right;
        }
        if(index!=largest)
        {
            int temp = arr.get(index);
            arr.set(index,arr.get(largest));
            arr.set(largest,temp);
            maxHeapify(arr,largest);
        }
    }


}
