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
class UniqueBinaryTree {
    public int countTree(int n,int[]dp){
        if(n==0 || n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=countTree(i,dp)*countTree(n-i-1,dp);
        }
        return dp[n]=ans;
    }
    public int numTrees(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return countTree(n,dp);
    }
}
