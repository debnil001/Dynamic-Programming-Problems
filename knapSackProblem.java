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
public class knapSackProblem {
    //recursive
    public static int knapSack(int[]val,int[]wt,int W,int n){
        if(n==0 || W==0)
            return 0;
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+knapSack(val,wt,W-wt[n-1],n-1);
            //exclude
            int ans2=knapSack(val,wt,W,n-1);
            
            return Math.max(ans1, ans2);
        }
        //exclude
        return knapSack(val,wt,W,n-1);
    }
            
     //momoized
     public static int knapSackMem(int[]val,int[]wt,int W,int n,int dp[][]){
        if(n==0 || W==0)
            return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+knapSackMem(val,wt,W-wt[n-1],n-1,dp);
            //exclude
            int ans2=knapSackMem(val,wt,W,n-1,dp);
           dp[n][W]=Math.max(ans1, ans2);
           return dp[n][W];
        }
        //exclude
        return dp[n][W]=knapSackMem(val,wt,W,n-1,dp);
    }
     //tabulation
     public static int knapSackTab(int[]val,int[]wt,int W,int n){
         int dp[][]=new int[n+1][W+1];
        for (int[] dp1 : dp) {
            dp1[0] = 0;
        }
         for(int j=0;j<dp[0].length;j++)
             dp[0][j]=0;
         
         for(int i=1;i<=n;i++){
             for(int j=1;j<=W;j++){
                 if(wt[i-1]<=j){
                     int includeProfit=val[i-1]+dp[i-1][j-wt[i-1]];
                     
                     int excludeProfit=dp[i-1][j];
                     
                     dp[i][j]=Math.max(includeProfit,excludeProfit);
                 }
                 else
                     dp[i][j]=dp[i-1][j];
             }
         }
        for(int d[]:dp){
            for(int i:d){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return dp[n][W];
     }
     //dp array
    public static void main(String args[]){
        int val[]=new int[]{15,14,10,45,30};
        int wt[]=new int[]{2,5,1,3,4};
        int W=7;
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]=-1;
        }
        
        System.out.println(knapSackMem(val,wt,W,val.length,dp));
        System.out.print(knapSackTab(val,wt,W,val.length));
    }
}
