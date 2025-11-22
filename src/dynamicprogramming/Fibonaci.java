package dynamicprogramming;

import java.util.Scanner;

public class Fibonaci {

    static int memo[];
    Fibonaci(int n){
        memo=new int[n+1];
        for(int i=0;i<n+1;i++){
            memo[i]=-1;
        }
    }

    public static void main(String args[]){
        System.out.println("Enter fib no : ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Fibonaci fibonaci=new Fibonaci(n);
        System.out.println("top down approach : "+fibTop(n));
        System.out.println("bottom up approach : "+fibBottom(n));
    }

    public static int fibTop(int n){
        if(memo[n]==-1){
            int res=0;
            if(n==0 || n==1){
                res=n;
            }else{
                res= fibTop(n-1)+fibTop(n-2);
            }
            memo[n]=res;
        }

        return memo[n];

    }

    public static int fibBottom(int n){
        int []fib=new int[n+1];
       fib[0]=0;
       fib[1]=1;
       for(int i=2;i<n+1;i++){
           fib[i]=fib[i-1]+fib[i-2];
           //System.out.println("fib[i-1] : "+fib[i-1]+", fib[i-2] : "+fib[i-2]);
       }
        return fib[n];
    }
}
