package com.bob.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_3Sum {
    /*
    hash+双指针
    双指针

     */
    public static  List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int i=0;
        //双指针滑动取值
        while (i<nums.length-2){
            if(nums[i]>0)break;
            int left=i+1,right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                    //去重
                    while (left<right && nums[left]==nums[left-1])++left;
                    while (left<right && nums[right]==nums[right+1])--right;
                }else if(sum<0)++left;
                else right--;
            }
            //若遇相等i则跳过
            while (nums[i]==nums[++i] && i<nums.length-2);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums={-2,-2,0,1,2,3,4};
        List<List<Integer>> res=threeSum(nums);
        for(List<Integer> item:res){
            for(Integer s:item){
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }
}
