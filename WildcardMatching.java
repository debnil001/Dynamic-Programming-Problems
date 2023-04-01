/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean[][]dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            dp[i][0]=false;
        }
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else
                    dp[i][j]=false;
            }
        }
        return dp[m][n];
    }
}
