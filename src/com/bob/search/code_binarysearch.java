package com.bob.search;

public class code_binarysearch {
    public static int search(int[] nums, int target) {
        int index=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            System.out.println(mid);
         if(nums[mid]<target){
            left=mid+1;
         }else if(nums[mid]>target){
             right=mid-1;
         }else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }
}
