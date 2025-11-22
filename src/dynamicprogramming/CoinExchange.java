package dynamicprogramming;

import java.util.Scanner;

public class CoinExchange {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int sum=scanner.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println("sum : "+findSum(n,sum,a));

        }
    }

    public static int findSum(int n, int sum, int []a){

        if(sum==0){
            return 1;
        }
        if(sum<0){
            return 0;
        }
        if(n==0){
            return 0;
        }
        int s1=findSum(n,sum-a[n-1],a);
        int s2=findSum(n-1,sum,a);
        return s1+s2;

    }

    public static int findDPSum(int n, int sum, int []a){

        int [][]dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum;j++){
                dp[i][j]=dp[i][j-1];
                if(a[i-1]<=j){
                    dp[i][j]+=dp[i][j-a[i-1]];
                }
            }
        }
        return dp[n][sum];
    }



}
