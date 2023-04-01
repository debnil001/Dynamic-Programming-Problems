/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

/**
 *
 * @author HP
 */
class UglyNumber {
    public int nthUglyNumber(int n) {
        int[]dp=new int[n+1];
        dp[1]=1;
        int p2=1,p3=1,p5=1;
        for(int i=2;i<=n;i++){
            int val1=2*dp[p2];
            int val2=3*dp[p3];
            int val3=5*dp[p5];

            int min=Math.min(Math.min(val1,val2),val3);

            dp[i]=min;

            if(min==val1)
                p2++;
            if(min==val2)
                p3++;
            if(min==val3)
                p5++;
        }
        return dp[n];
    }
}
