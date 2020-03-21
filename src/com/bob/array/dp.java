package com.bob.array;

import java.util.HashSet;
import java.util.Set;

public class dp {
    boolean[][] res_isMatch;

    //比特位计数：每个数字中包含1的个数
    public int[] countBits(int num) {
        
        

    }
    //字符串模式匹配
    public boolean isMatch(String s, String p) {
        res_isMatch=new boolean[s.length()+1][s.length()+1];
        //子问题，状态空间，初始状态，状态转移方程,还分为自顶向下、自底向上两种方式
        return dp_IsMatch(0,0,s,p);

    }
    public boolean dp_IsMatch(int i,int j,String s,String p) {
        if (new Boolean(res_isMatch[i][j])!=null) {
            return res_isMatch[i][j] == true;
        }
        boolean ans;
        //当前模式串匹配完了后，判断是否完全匹配上了，如果s没有匹配到最后，则未匹配上，否则完全匹配
        if(j==p.length())ans=i==s.length();
        else{
            //第一次匹配的判断
            boolean first_match=(i<s.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.'));
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                ans=(dp_IsMatch(i,j+2,s,p)|| first_match && dp_IsMatch(i+1,j,s,p));
            }else{
                ans=first_match && dp_IsMatch(i+1, j+1, s, p);
            }
        }
        res_isMatch[i][j]=ans?true:false;

        return ans;
    }

    public int orderOfLargestPlusSign(int N,int[][] mines){
        Set<Integer> banned=new HashSet<Integer>();
        int[][] dp=new int[N][N];
        for(int[] mine:mines){


        }



        return 0;
    }
    //最长回文子串
    public String longestPalindrome(String s){
        if(s.isEmpty())return s;
        String res=s.substring(0,1);
        //暴力法
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String k=s.substring(i,j);
                String rk=new StringBuffer(k).reverse().toString();
                if(k.equals(rk) && k.length()>res.length())res=k;
            }
        }
        //动态规划：最优子结构、边界、状态转移方程
        int left=0;
        int right=0;
        int length=s.length();
        boolean[][] dp=new boolean[length][length];
        for(int i=length-2;i>=0;i--){
            dp[i][i]=true;
            for(int j=i+1;j<length;j++){
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(dp[i+1][j-1] || j-i<3);
                if(dp[i][j] && right-left<j-i){
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }
    public static void main(String[] args){
        int[][] dp=new int[][]{{1,2},{3,4},{5,6}};
        System.out.println(dp[1][2]);
    }
}
