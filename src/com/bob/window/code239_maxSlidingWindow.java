package com.bob.window;

import java.util.ArrayDeque;

public class code239_maxSlidingWindow {
    ArrayDeque<Integer> deq=new ArrayDeque<>();
    int nums[];
    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n*k==0)return new int[0];
        if(k==1)return nums;
        this.nums=nums;
        int max_idx=0;
        for (int i=0;i<k;i++){
            clean_deque(i,k);
            deq.addLast(i);
            if(nums[i]>nums[max_idx])max_idx=i;
        }
        int[] output=new int[n-k+1];
        output[0]=nums[max_idx];
        for (int i=k;i<n;i++){
            clean_deque(i,k);
            output[i-k+1]=nums[deq.getFirst()];
        }
        return output;
//        int left=0,right=k-1;
//        int[] res=new int[nums.length-k+1];
//        int first=0,second=0;
//        int index=0;
//        for(int i=0;i<k;i++){
//            if(nums[i]>first)first=nums[i];
//            if(nums[i]<first && nums[i]>second)second=nums[i];
//            res[index]=first;
//            index++;
//            left++;
//            right++;
//        }
//        while(right<nums.length){
//            if(nums[right]>first){
//                 first=nums[right];
//                 res[index]=first;
//            }
//        }
//        return res;

    }
}
