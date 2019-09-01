package com.bob.sum;

import java.util.Arrays;

public class code_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
       int diff=0;
       while(true){
           if(threeSum(nums,target+diff))return target+diff;
           if(diff>0 && threeSum(nums,target-diff))return target-diff;
           diff++;
       }
    }

    private boolean threeSum(int[] nums, int target) {
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target)return true;
                else if(sum>target)right--;
                else left++;
            }
        }
        return false;
    }


}
