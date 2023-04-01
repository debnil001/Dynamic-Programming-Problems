/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class DistinctSubseq {
    public int find(String s,String t,int m,int n){
        int[][]dp=new int[m+1][n+1];
        for(int j=0;j<=m;j++){
            dp[j][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[m][n];
    }
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int ans=find(s,t,m,n);
        return ans;
    }
}
