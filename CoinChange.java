/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int j=0;j<=amount;j++){
            dp[0][j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j%coins[i-1]==0)
                    dp[i][j]=j/coins[i-1];
                else
                    dp[i][j]=Integer.MAX_VALUE-1;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    //take
                    int ans1=(1+dp[i][j-coins[i-1]]);
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.min(ans1,ans2);
                }
                //not take
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[n][amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[n][amount];
    }
}
