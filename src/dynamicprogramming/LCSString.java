package dynamicprogramming;

import java.util.Scanner;


public class LCSString {

    static int [][] memo=null;

    LCSString(int m,int n){
        memo=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }
    }

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {

            int m = scanner.nextInt();
            String s1 = scanner.next();

            int n = scanner.nextInt();
            String s2 = scanner.next();

            //for empty string comparsion
            LCSString lcsString=new LCSString(m+1,n+1);

            System.out.println(lcsRecurrsion(s1,s2,m,n));
            //System.out.println(lcsTopDownApproach(s1,s2,m,n));
            System.out.println(lcsBottomUpApproach(s1,s2,m,n));
        }
    }

    private static int lcsRecurrsion(String s1, String s2, int m, int n) {

        if(m==0 || n==0){
            return 0;
        }

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+lcsRecurrsion(s1,s2,m-1,n-1);
        }else{
            return Math.max(lcsRecurrsion(s1,s2,m,n-1),lcsRecurrsion(s1,s2,m-1,n));
        }
    }

    private static int lcsTopDownApproach(String s1, String s2, int m, int n) {


        if(memo[m][n]!=-1){
            return memo[m][n];
        }else{
            if(m==0 || n==0){
                memo[m][n]=0;
            }else{
                if(s1.charAt(m-1)==s2.charAt(n-1)){
                    memo[m][n]= 1+lcsRecurrsion(s1,s2,m-1,n-1);
                }else{
                    memo[m][n]= Math.max(lcsRecurrsion(s1,s2,m,n-1),lcsRecurrsion(s1,s2,m-1,n));
                }
            }
            return memo[m][n];
        }
    }

    private static int lcsBottomUpApproach(String s1, String s2, int m, int n) {

        int [][]dp=new int[m+1][n+1];
       for(int i=0;i<=m;i++){
           dp[i][0]=0;
       }
       for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }

       for(int i=1;i<m+1;i++){
           for(int j=1;j<n+1;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;
               }else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }

           }

       }
       return dp[m][n];

    }

}
