package LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Soultion480 {
    public static void main(String[] args) {
        Soultion480 s = new Soultion480();
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;
        System.out.println(s.medianSlidingWindow(nums,k));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((Collections.reverseOrder()));
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int delete = 0;
        int balance = 0;

        int len = nums.length;
        double[] results = new double[len-k+1];

        for (int i=0; i<k; i++) {
            maxheap.add(nums[i]);
            minheap.add(maxheap.poll());
            if ((maxheap.size() + minheap.size())%2 != 0)
                maxheap.add(minheap.poll());
        }
        if ((maxheap.size()+minheap.size())==1)
            results[0] = maxheap.peek();
        else if ((maxheap.size()+minheap.size())%2 != 0)
            results[0] = maxheap.peek();
        else
            results[0] =  ((double)minheap.peek() + (double)maxheap.peek())/2.0;

        //should_delete.add(nums[0]);
        delete = nums[0];
        for (int j=1; j<len-k+1; j++) {
//            if (j==4)
//                j=4;
            int index = j+k-1;
            maxheap.add(nums[index]);
            minheap.add(maxheap.poll());
            if ((maxheap.size() + minheap.size())%2 != 0)
                maxheap.add(minheap.poll());

            if (delete <= maxheap.peek()) {
                maxheap.remove(delete);
            } else {
                minheap.remove(delete);
            }

            heapBalance(maxheap,minheap);

            if ((maxheap.size()+minheap.size())%2 != 0)
                results[j] = maxheap.peek();
            else
                results[j] = ((double)minheap.peek() + (double)maxheap.peek())/2.0;

            //should_delete.add(nums[j]);
            delete = nums[j];
        }
        return results;
    }

    public void heapBalance(PriorityQueue<Integer> maxheap,PriorityQueue<Integer> minheap) {
        if (maxheap.size() < minheap.size())
            maxheap.add(minheap.poll());
        if (maxheap.size() > minheap.size()+1)
            minheap.add(maxheap.poll());
    }

}
