package com.bob.window;

import java.util.HashMap;
import java.util.Map;

public class code_minWindow {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length() <t.length())return "";
        Map<Character,Integer> dict=new HashMap<>();
        Map<Character,Integer> current=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        int l=0,r=0,required=dict.size(),formated=0;
        int[] res={-1,0,0};
        while(r<s.length()){
            char c=s.charAt(r);
            current.put(c,current.getOrDefault(c,0)+1);
            if(dict.containsKey(c)&&current.get(c).intValue()==dict.get(c).intValue())formated++;
            while(l<=r && formated==required){
                c=s.charAt(l);
                if(res[0]==-1 || r-l+1<res[0]){
                    res[0]=r-l+1;
                    res[1]=l;
                    res[2]=r;
                }
                current.put(c,current.get(c)-1);
                if(dict.containsKey(c)&&current.get(c).intValue()<dict.get(c).intValue())formated--;
                l++;
            }
            r++;
        }
        return res[0]==-1?"":s.substring(res[1],res[2]+1);
    }
}
