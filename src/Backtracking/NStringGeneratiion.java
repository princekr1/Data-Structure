package Backtracking;

public class NStringGeneratiion {
    int [] a=new int[5];
    int count=0;
    public void generateString(int n,int k){
        if(n==0){
            printArray(a);
            count++;
            return;
        }
        for(int i=0;i<k;i++){
            a[n-1]=i;
            generateString(n-1,k);
        }
        /* K is 2 (0.1)
        a[n-1]=0;
        generateString(n-1);
        a[n-1]=1;
        generateString(n-1);*/

    }
    public void printArray(int []a){
        for(int i:a){
            System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String args[]){
        NStringGeneratiion nStringGeneratiion=new NStringGeneratiion();
        nStringGeneratiion.generateString(5,4);
        System.out.println("Number of ArrayString generated : "+nStringGeneratiion.count);
    }
}
