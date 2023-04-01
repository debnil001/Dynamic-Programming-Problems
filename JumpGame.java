/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        int i,n=nums.length;
        for(i=0;i<n && maxReach>=i;i++){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(maxReach>=n-1)
                return true;
        }
        if(i==n)
            return true;
        else
            return false;
    }
}
