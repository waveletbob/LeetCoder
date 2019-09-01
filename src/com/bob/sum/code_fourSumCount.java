package com.bob.sum;

import java.util.HashMap;
import java.util.Map;

public class code_fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> a_b=new HashMap<>();
        for(int a:A){
            for(int b:B){
                a_b.put(a+b,a_b.getOrDefault(a+b,0)+1);
            }
        }
        int res=0;
        for(int c:C){
            for(int d:D){
                int target=-(c+d);
                if(a_b.containsKey(target))res+=a_b.get(target);
            }
        }
        return res;
    }
}
