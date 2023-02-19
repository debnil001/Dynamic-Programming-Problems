/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
//
// 
//
//Example 1:
//
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
//variation of longest common substring 
//tabultation solve
class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=0;
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(dp[i][j],ans);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]){
        
    }
}

