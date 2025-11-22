package walmart;

import java.util.Arrays;

public class ArrayTripletsum {

    public static boolean tripletSum(int []arr, int tripletSum){

        Arrays.sort(arr);

        for(int i=0;i+1<arr.length;i++){
            int left=i+1;
            int right= arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==tripletSum){
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    return true;
                }else if(sum < tripletSum){
                    left++;
                }else{
                    right--;
                }
            }

        }
        System.out.println("No triplet found with sum " + tripletSum);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        int sum = 24;

        tripletSum(arr, sum);
    }
}
