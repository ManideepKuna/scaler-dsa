package heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class BNegations {
    public int solve(ArrayList<Integer> A, int B) {
        int sum=0;
        for(int i=(A.size()/2)-1 ;i>=0;i--)
        {
            minHeapify(A,i);
            System.out.println("----");
        }
        
        while(B!=0)
        {
            int min = A.get(0);
            if(min>0)
            {
                if(B%2 != 0)
                {
                    A.set(0,-A.get(0));
                }
            }
            else{
                A.set(0,-A.get(0));
                minHeapify(A,0);
            }
            --B;
        }
        for(int i=0;i<A.size();i++)
        {
            sum = sum + A.get(i);
        }
        return sum;
    }

    public void minHeapify(ArrayList<Integer> A, int i)
    {
        int smallest;
        int left = (2*i)+1;
        int right = (2*i)+2;
        if(left<A.size() && A.get(left)<A.get(i))
        {
            smallest = left;
        }
        else
        {
            smallest = i;
        }
        if(right<A.size() && A.get(right)<A.get(smallest))
        {
            smallest = right;
        }
        if(i != smallest)
        {
            int temp = A.get(i);
            A.set(i,A.get(smallest));
            A.set(smallest,temp);
            minHeapify(A,smallest);
        }
    }

    public static void main(String[] args) {
        BNegations BNegations = new BNegations();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-43, -1, 19, 87, -45));
        BNegations.solve(list,5);
    }
}