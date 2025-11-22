package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ThreeSumPythagoreanTriplet {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter elements in array : ");
        int n=scanner.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Input complete.");
        System.out.println("result : "+findThreeSumPythagoreanTripletHashMap(arr));
    }

    private static Boolean findThreeSumPythagoreanTriplet(int[] arr) {

        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);

        for(int i=arr.length-1;i>-1;i--){
            int left=0;
            int right=i-1;
            while(left<right){
                if(arr[left]+arr[right]>arr[i]){
                        right--;
                }else if(arr[left]+arr[right]<arr[i]){
                    left++;
                }else{
                    return true;
                }
            }

        }
        return false;
    }

    private static Boolean findThreeSumPythagoreanTripletHashMap(int[] arr) {

        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hashSet.add(arr[i]*arr[i]);
        }



        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a=arr[i]*arr[i];
                int b=arr[j]*arr[j];

                int c=a+b;

                if(hashSet.contains(c)){
                    return true;
                }
            }

        }
        return false;
    }
}
