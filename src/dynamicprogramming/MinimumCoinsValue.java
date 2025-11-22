package dynamicprogramming;

import java.util.Scanner;

public class MinimumCoinsValue {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int val=scanner.nextInt();
            int n=scanner.nextInt();
            int []a =new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            
            System.out.println(findMinimumCoinused(a,0,val));
        }
    }

    private static int findMinimumCoinused(int[] a, int i, int val) {

        if(val<0 || i >a.length-1){
            return Integer.MAX_VALUE;
        }
        if(val==0){
            return 0;
        }
        int res=Math.min(
        findMinimumCoinused(a,i,val-a[i])+1,
        findMinimumCoinused(a,i+1,val));
        return res;
    }
    private static int getMin(int coins[], int n, int val){
        if(val==0){
            return 0;
        }
        int res= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            if(coins[i]<=val){
                res=getMin(coins,n-1,val-coins[n-1]);
            }
        }
        return res;
    }

    private static int getMinDP(int coins[], int n, int val){

        int []dp=new int[val+1];
        int res= Integer.MAX_VALUE;
        for(int i=1;i<val+1;i++){
            for(int j=0;j<n;j++){
                if(coins[i]<=val){
                    
                }
            }
        }
        return 0;
    }


}
