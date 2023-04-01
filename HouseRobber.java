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
class HouseRobber {
    public int help(int[]nums,int[]dp,int index,int n){
        if(index>n)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int way1=nums[index]+help(nums,dp,index+2,n);
        int way2=help(nums,dp,index+1,n);
        
        return dp[index]=Math.max(way1,way2);
    }
    public int helpTab(int[]nums){
        int n=nums.length;
        int dp[]=new int[n];
        int way1=0;
        int way2=0;
        for(int i=0;i<=n-1;i++){
            way1=nums[i]+(i>=2?dp[i-2]:0);
            way2=(i>=1?dp[i-1]:0);
            dp[i]=Math.max(way1,way2);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int[]dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helpTab(nums);
    }
}
