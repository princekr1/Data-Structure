package codeforce;


public class BinarySearch {

    public static int binarySearchFirst(int arr[], int target) {
        int left = 0;
        int result=-1;
        int right = arr.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                right=mid-1;
                result= mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static int binarySearchLast(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int result=-1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                left=mid+1;
                result= mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String args[]){

        int arr[]= {1,2,3,4,5,7,7,7,9,10};
        int target=7;
        int left=binarySearchFirst(arr,target);

        int right=binarySearchLast(arr,target);
        System.out.println("Element found at first index : "+left+", last index : "+right);
    }
}
