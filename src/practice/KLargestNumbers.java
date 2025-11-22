package practice;

import java.util.*;

public class KLargestNumbers {

    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter elements in array : ");
        int n=scanner.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.print("Enter k : ");
        int k=scanner.nextInt();
        if(k<n){
            findKLargestNumbers(arr, k);
        }else{
            Arrays.sort(arr);
            printArray(arr);
        }

    }

    //write an array print function
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void findKLargestNumbers(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            priorityQueue.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            int minHeap= priorityQueue.peek();
            System.out.println("minHeap : "+minHeap);
            if(arr[i]>minHeap){
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        List<Integer> result= new ArrayList<>(priorityQueue.stream().toList());
        Collections.reverse(result);
        System.out.println(result);

    }
}
