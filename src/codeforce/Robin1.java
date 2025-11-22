package codeforce;

import java.util.Scanner;

public class Robin1 {

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int countZero = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != 0) {
                    if(a[i]>k-1){
                        sum = sum + a[i];
                    }
                } else {
                    if(sum!=0){
                        countZero++;
                        sum--;
                    }
                }
            }

            System.out.println(countZero);
        }
    }
}
