/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
public class EditDistance {
    public static int countOperationsTAB(String s1,String s2,int len1,int len2){
        int dp[][]=new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    int ans1=1+dp[i][j-1];
                    int ans2=1+dp[i-1][j];
                    int ans3=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }
        return dp[len1][len2];
    }
    public static int countOperations(String s1,String s2,int len1,int len2){
        if(len1==0)
            return len2;
        if(len2==0)
            return len1;
        if(s1.charAt(len1-1)==s2.charAt(len2-1))
            return countOperations(s1,s2,len1-1,len2-1);
        else{
            int option1=1+countOperations(s1,s2,len1,len2-1);
            int option2=1+countOperations(s1,s2,len1-1,len2);
            int option3=1+countOperations(s1,s2,len1-1,len2-1);
            int finalAns=Math.min(option1, Math.min(option2, option3));
            return finalAns;
        }
    }
    public static void main(String[]args){
             String s1="abcefg";
             String s2="sbdefr";
             System.out.println(countOperations(s1, s2, s1.length(), s2.length()));
                          System.out.println(countOperationsTAB(s1, s2, s1.length(), s2.length()));

    }
}
