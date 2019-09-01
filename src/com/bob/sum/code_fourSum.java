package com.bob.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-3){
            System.out.println("i:"+i);
//            if(nums[i]>target)break;
            int j=i+1;
            while(j<nums.length-2){
                System.out.println("j:"+j);
//                if((nums[i]+nums[j])>target)break;
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                        while (left<right && nums[left]==nums[left-1])++left;
                        while (left<right && nums[right]==nums[right+1])--right;
                    }else if(sum>target)right--;
                    else left++;
                }
                while(nums[j]==nums[++j]&&j<nums.length-2);
            }
            while(nums[i]==nums[++i]&&i<nums.length-3);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        List<List<Integer>> res=fourSum(nums,-11);
        for(List<Integer> item:res){
            for(int i:item)System.out.println(i+"\t");
            System.out.println();
        }

    }
}
