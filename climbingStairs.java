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
public class climbingStairs {
    //recursion
    public static int countWays(int n){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        return countWays(n-1)+countWays(n-2);
    }
    //memoization
    public static int countWaysMem(int n,int dp[]){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=countWaysMem(n-1,dp)+countWaysMem(n-2,dp);
    }
    //tabulation
    public static int countWaysTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1)
              dp[i]=dp[i-1]+0;
            else
                dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }

    public static void main(String[]args){
        int n=6;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(countWaysTab(n));
    }
}
