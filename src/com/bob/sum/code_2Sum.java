package com.bob.sum;

import java.util.HashMap;

public class code_2Sum {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
