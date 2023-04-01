/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author HP
 */
class MaximumAlternatingSum {
    static long max=Integer.MIN_VALUE;
    public long MAS(int[]nums,int sign,int curr,long[][]dp){
        if(curr==nums.length)
            return 0;
        if(dp[(sign==-1)?0:1][curr]!=-1)
            return dp[(sign==-1)?0:1][curr];
        long ans1=(sign*nums[curr])+MAS(nums,-1*sign,curr+1,dp);
        long ans2=MAS(nums,sign,curr+1,dp);

        return dp[(sign==-1)?0:1][curr]=Math.max(ans1,ans2);

    }
    public long maxAlternatingSum(int[] nums) {
        long dp[][]=new long[2][nums.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        return MAS(nums,1,0,dp);
    }
}
