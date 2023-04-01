/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
public class longestCommonSubseq {
    public static int findLongestSubseq(String s1,String s2,int len1,int len2){
        if(len1==0 || len2==0)
             return 0;
        if(s1.charAt(len1-1)==s2.charAt(len2-1)){
            return 1+findLongestSubseq(s1,s2,len1-1,len2-1);
        }
        else{
            return Math.max(findLongestSubseq(s1,s2,len1,len2-1), findLongestSubseq(s1,s2,len1-1,len2));
        }
 }
//      public static int findLongestSubString(String s1,String s2,int len1,int len2){
//        if(len1==0 || len2==0)
//             return 0;
//        if(s1.charAt(len1-1)==s2.charAt(len2-1)){
//            return 1+findLongestSubString(s1,s2,len1-1,len2-1);
//        }
//        else{
//            return 0;
//        }
    //memoize
    public static int lcs(String s1,String s2,int len1,int len2,int[][]dp){
        if(len1==0 || len2==0)
            return 0;
        if(dp[len1][len2]!=0)
            return dp[len1][len2];
        if(s1.charAt(len1-1)==s2.charAt(len2-1)){
            return dp[len1][len2]=1+lcs(s1,s2,len1-1,len2-1,dp);
        }
        else {
            int ans1=lcs(s1,s2,len1-1,len2,dp);
            int ans2=lcs(s1,s2,len1,len2-1,dp);
            return dp[len1][len2]=Math.max(ans1, ans2);
        }
//        return dp[len1][len2];
    }
    public static int lcsTabulation(String s1,String s2,int len1,int len2){
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=len2;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[]args){
        String s1="abcde";
        String s2="abc";
        int len1=s1.length(),len2=s2.length();
        int[][]dp=new int[len1+1][len2+1];
        for(int i=0;i<len1;i++)
            dp[i][0]=0;
        for(int j=0;j<len2;j++)
            dp[0][j]=0;
        System.out.println(lcsTabulation(s1,s2,s1.length(),s2.length()));
//        System.out.println(findLongestSubString(s1,s2,s1.length(),s2.length()));
    }
}
