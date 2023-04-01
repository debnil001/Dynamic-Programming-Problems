/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class MinimumCostForTickets {
    int solveMem(int[]days,int[]costs,int[]dp,int index,int n){
        if(index>=n)
            return 0;
        if(dp[index]!=-1) return dp[index];

        int ans1=costs[0]+solveMem(days,costs,dp,index+1,n);
        int i;
        for(i=index;i<n && days[index]+7>days[i];i++);

        int ans2=costs[1]+solveMem(days,costs,dp,i,n);

        for(i=index;i<n && days[index]+30>days[i];i++);
        int ans3=costs[2]+solveMem(days,costs,dp,i,n);

        return dp[index]=Math.min(ans1,Math.min(ans2,ans3));
    }
    int solveTab(int[]days,int[]costs,int index,int n){
        int dp[]=new int[n+1];
        dp[n]=0;
        for(int k=n-1;k>=0;k--){
            int ans1=costs[0]+dp[k+1];
            int i;
            for(i=k;i<n && days[k]+7>days[i];i++);

            int ans2=costs[1]+dp[i];

            for(i=k;i<n && days[k]+30>days[i];i++);
            int ans3=costs[2]+dp[i];

            dp[k]=Math.min(ans1,Math.min(ans2,ans3));
        }
        return dp[0];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        // int[]dp=new int[n];
        // Arrays.fill(dp,-1);
        return solveTab(days,costs,0,n);
    }
}