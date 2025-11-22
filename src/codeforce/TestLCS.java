package codeforce;

import java.util.Scanner;

public class TestLCS {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
        }
    }

        private static int lcsBottomUpApproach(String s1, String s2, int m, int n) {

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(s1.charAt(i)==s2.charAt(j)){

                    }else if(s1.charAt(i)=='?'){

                    }
                }
            }
            return 0;
        }
}
