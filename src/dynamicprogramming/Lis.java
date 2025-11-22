package dynamicprogramming;

import java.util.Scanner;

public class Lis {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            findLisCount(arr,0,1);
        }
    }

    private static int findLisCount(int[] arr, int i,int j) {

        if(j>arr.length-1){
            return 0;
        }

        if(arr[j]>arr[i]){
            return 1+findLisCount(arr,j,j+1);
        }else{
            return findLisCount(arr,i,j+1);
        }
    }
}
