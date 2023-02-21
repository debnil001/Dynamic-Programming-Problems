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
