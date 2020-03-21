package com.bob.array;

import java.util.HashMap;
import java.util.Map;

public class lenLongestFibSubseq {
    //最长的斐波拉契子序列长度,
    // 动态规划：状态定义、状态转移方程(i->j->k)dp[j][k]=dp[i][j]+1
    public static int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) {
            index.put(A[i], i);
        }
        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    //此处是为了获取当前的最大路径，longest通过i*N+j来存储i，j结尾的最大路径长度
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }

        return ans >= 3 ? ans : 0;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int ans=lenLongestFibSubseq(array);
        System.out.println(ans);


    }
}
