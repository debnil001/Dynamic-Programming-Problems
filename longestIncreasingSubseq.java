/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
public class longestIncreasingSubseq {
    public static int findLIS(int[] arr,int index,int prevIdx){
        if(index==arr.length)
            return 0;
        int len1=0+findLIS(arr,index+1,prevIdx);
        int len2 = 0;
        if(prevIdx==-1 || arr[index]>arr[prevIdx]){
            prevIdx=index;
            len2=1+findLIS(arr,index,prevIdx);
        }
        return Math.max(len1, len2);
    }
    public static void main(String[]args){
        int arr[]=new int[]{5,3,9,6,10,11,50,12,25};
        System.out.println(findLIS(arr,0,-1));
    }
}
//memoized code
class Solution {
    public int LIS(int[]nums,int index,int prevIndex,int[][]dp,int len){
        if(index==len)
            return 0;
        if(dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];
        int len1=LIS(nums,index+1,prevIndex,dp,len);
        int len2=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            prevIndex=index;
            len2=1+LIS(nums,index+1,prevIndex,dp,len);
        }
        dp[index][prevIndex+1]=Math.max(len1,len2);
        return dp[index][prevIndex+1];
    }
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int dp[][]=new int[len][len+1];
        for(int i=0;i<len;i++){
            for(int j=0;j<len+1;j++)
                dp[i][j]=-1;
        }
        return LIS(nums,0,-1,dp,len);
    }
}
//tabulation code

class Solution {
    public int LIS(int index,int[]dp,int nums[]){
        if(dp[index]!=-1) return dp[index];
        int ans=1;
        for(int j=0;j<index;j++){
            if(nums[index]>nums[j]){
                ans=Math.max(ans,1+LIS(j,dp,nums));
            }
        }
        return dp[index]=ans;
    }
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int dp[]=new int[len+1];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,LIS(i,dp,nums));
        }
        return ans;
    }
}
