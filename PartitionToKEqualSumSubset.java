/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author HP
 */
class PartitionToKEqualSumSubset {
    public boolean findSubsets(int start,int k,int subsetSum,
    int target,int[]nums,boolean[] visit){
        if(k==0)
            return true;
        if(subsetSum==target)
            return findSubsets(0,k-1,0,target,nums,visit);
        
        for(int i=start;i<nums.length;i++){
            if(visit[i] || (subsetSum+nums[i])>target)
                continue;
            visit[i]=true;
            if(findSubsets(i+1,k,subsetSum+nums[i],target,nums,visit)){
                return true;
            }
            visit[i]=false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        Integer[] temp=new Integer[n];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            temp[i]=nums[i];
        }
        if(sum%k!=0)
            return false;
        Arrays.sort(temp, Collections.reverseOrder());
        for(int i=0;i<n;i++)
            nums[i]=temp[i];
        int target=sum/k;
        boolean visit[]=new boolean[n];
        return findSubsets(0,k,0,target,nums,visit);        
    }
}
