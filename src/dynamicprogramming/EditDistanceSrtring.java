package dynamicprogramming;

import java.util.Scanner;

public class EditDistanceSrtring {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            String s1=scanner.next();
            String s2=scanner.next();

            System.out.println("make string s1:"+s1+", String s2 : "+s2+" identical operations required is : "+editDistance(s1,s2,s1.length(),s2.length()));

            System.out.println("make string s1:"+s1+", String s2 : "+s2+" DP identical operations required is : "+editDistanceBottomUp(s1,s2,s1.length(),s2.length()));
        }
    }

    private static int editDistance(String s1, String s2,int m,int n) {

        if(m==0){
            return n;
        }else if(n==0){
            return m;
        }

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return editDistance(s1, s2, m-1, n-1);
        }else{
            int count= Math.min(editDistance(s1,s2,m-1,n),editDistance(s1,s2,m,n-1));
            return 1+ Math.min(editDistance(s1,s2,m-1,n-1),count);
        }
    }

    private static int editDistanceBottomUp(String s1, String s2,int m,int n) {


        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int count= Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]= 1+ Math.min(dp[i-1][j-1],count);
                }
            }
        }
        return dp[m][n];
    }
}
