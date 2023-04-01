/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class PartitionToTwoEqualSubset {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int w=sum/2;
        int dp[][]=new int[n+1][w+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                int num=nums[i-1];
                if(num<=j){
                    int ans1=num+dp[i-1][j-num];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][w];
        int sum2=sum-sum1;
        return sum1==sum2;
    }
}
