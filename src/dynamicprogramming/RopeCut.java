package dynamicprogramming;

import java.util.Scanner;

public class RopeCut {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int ropLength=scanner.nextInt();
            int n=scanner.nextInt();
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            //int result=findMaxCuts(ropLength,a[0],a[1],a[2]);
            int result=findMaxCutsDP(ropLength,a[0],a[1],a[2]);
            System.out.println("result : "+result);
        }
    }

    private static int findMaxCutsDP(int ropLength, int a, int b, int c) {

        int []res=new int[ropLength+1];
        res[0]=0;
        for(int i=1;i<ropLength+1;i++){
            res[i] =-1;
            if(i-a>=0){
               res[i]= Math.max(res[i-a],res[i]);
            }
            if(i-b>=0){
                res[i]= Math.max(res[i-b],res[i]);
            }
            if(i-c>=0){
                res[i]= Math.max(res[i-c],res[i]);
            }
            if(res[i]!=-1){
                res[i]++;
            }
        }
        return res[ropLength];

    }

    private static int findMaxCuts(int ropLength, int a, int b, int c) {

        if(ropLength<0){
            return -1;
        }else if (ropLength==0){
            return 0;
        }

        int temp=Math.max(findMaxCuts(ropLength-a,a,b,c),findMaxCuts(ropLength-b,a,b,c));
        temp=Math.max(findMaxCuts(ropLength-c,a,b,c), temp);
        if(temp==-1){
            return -1;
        }
        return temp+1;
    }

    // DP solutions

}
