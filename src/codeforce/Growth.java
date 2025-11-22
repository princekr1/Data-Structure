package codeforce;

import java.util.Scanner;

public class Growth {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int sum=0;
            int arr[]=new int[n];
            for(int i=1;i<n+1;i++){
                sum= (int) (sum+Math.pow(i,i));
                //if(i-k)
            }
            if(sum%2==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
