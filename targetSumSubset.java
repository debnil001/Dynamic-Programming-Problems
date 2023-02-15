/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
public class targetSumSubset {
    public static boolean targetSum(int val[],int target,int n){
        boolean dp[][]=new boolean[n+1][target+1];
        
        for(int i=0;i<=n;i++)
            dp[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(val[i-1]<=j){
                    if(dp[i-1][j-val[i-1]]==true)
                        dp[i][j]=true;
                }
                else if(dp[i-1][j]==true)
                    dp[i][j]=true;
            }
        }
        for(boolean d[]:dp){
            for(boolean i:d){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        int count=0;
        for(int i=0;i<=n;i++){
            if(dp[i][target]==true){
                count++;
            }
        }
        System.out.println(count);
        return dp[n][target]; 
    }
    public static void main(String[]args){
        int val[]=new int[]{1,1,1,1,1};
        System.out.println(targetSum(val, 3, val.length));
    }
}
