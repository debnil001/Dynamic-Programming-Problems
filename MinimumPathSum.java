/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class Solution {
    public int helper(int[][]grid,int m,int n,int[][]dp){
        int inf=10000000;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)
                    dp[i][j]=grid[i][j];
                else{
                    dp[i][j]=grid[i][j]+Math.min((i==0)?inf:dp[i-1][j],(j==0)?inf:dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        
        return helper(grid,m,n,dp);
    }
}
