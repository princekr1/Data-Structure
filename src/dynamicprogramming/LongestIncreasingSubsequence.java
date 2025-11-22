package dynamicprogramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n=scanner.nextInt();
            int []a =new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }

            int result=findLis(n,a);

            System.out.println("result : "+result);


        }
    }

    private static int findLis(int n, int[] a) {
        int []lis=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int res=lis[0];
        for(int i=1;i<n;i++){
            res=Math.max(res,lis[i]);
        }
        return res;
    }

    private static int findLisTail(int n, int []a){
        int[] tail=new int[n];
        tail[0]=a[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(tail[len-1]>a[i]){
                tail[i]=a[i];
                len++;
            }else{
                int ceil=findCeilIndexBs(tail,0,len-1,a[i]);
                tail[ceil]=a[i];
            }
        }
        return 0;
    }

    private static int findCeilIndexBs(int[] tail, int l, int r, int x) {
        while(l<r){
            int mid=l+(r-l)/2;
            if(tail[mid]>x){
                r=mid;
            }else{
                l=mid;
            }

        }
        return 0;
    }
}
