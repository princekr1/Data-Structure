package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSumProblem {

    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter elements in array : ");
        int n=scanner.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.print("Enter target : ");
        int target=scanner.nextInt();

        System.out.println("result : "+twoSumCountHashset(arr, target));
    }

    private static Boolean twoSum(int[] arr, int target) {

        Arrays.sort(arr);

        int left=0;
        int right=arr.length-1;

        while(left<right){
            if(arr[left]+arr[right]>target){
                right--;
            } else if (arr[left]+arr[right]<target) {
                left++;
            }else{
                return true;
            }
        }
        return false;
    }

    private static Boolean twoSumHashset(int []arr, int target){

        HashSet<Integer> hashSet=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(hashSet.contains(target-arr[i])){
                return true;
            }else{
                hashSet.add(arr[i]);
            }
        }
        return false;
    }

    private static int twoSumCountHashset(int []arr, int target){

        HashSet<Integer> hashSet=new HashSet<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(hashSet.contains(target-arr[i])){
                count++;
            }else{
                hashSet.add(arr[i]);
            }
        }
        return count;
    }

    private static Boolean twoSumCount(int[] arr, int target) {

        Arrays.sort(arr);

        int left=0;
        int right=arr.length-1;

        while(left<right){
            if(arr[left]+arr[right]>target){
                right--;
            } else if (arr[left]+arr[right]<target) {
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
}
