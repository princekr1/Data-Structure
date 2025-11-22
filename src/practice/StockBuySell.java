package practice;

import java.util.Scanner;

public class StockBuySell {

    //https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
    public static void main(String args[]){

        System.out.println("Enter number of items :");
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(stockBuyAndSell(arr));

    }

    private static int stockBuyAndSell(int[] arr) {
        int val=0;
        if(arr==null || arr.length==0){
            return 0;
        }else{
            int current=arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]-current>val){
                    val=arr[i]-current;
                }else if(arr[i]<current){
                    current=arr[i];
                }
            }

        }
        return val;
    }

}
