package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class Wealth {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            int mid=n%2==0?n/2:(n+1)/2;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            if(a.length<3){
                System.out.println(-1);
            }else{
                Arrays.sort(a);
                int sum=0;

                for(int i=0;i<n;i++){
                    sum=sum+a[i];
                }
                int val=sum/n;
                val=val/2;
                int x=0;
                x = (a[mid]-val)*2*n;
                System.out.println(x);
            }

        }
    }
}
