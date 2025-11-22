package GeeksForgeeks.recurrsion;

/*Question : performing maxing cuts on a rope based of different type of cut length provided
ex: rop length : 5, cuts which can be performed is 1,2,3
result : 5 (we can perform s cuts of length 1)*/
public class RobCutProblem {

    public static void main(String args[]){
        int ropeLength=9;
        int[] arr={4,2,3,6,5};
        int max=0;
        for(int i=0;i<arr.length;i++){
            int count=countRopeCuts(ropeLength,arr,i);
            max=count>max?count:max;
        }
        System.out.println(max);

    }

    public static int countRopeCuts(int ropeLength, int []arr,int i){
        int countA=0,countB=0,countC=0;
        if (ropeLength==0){
            return 0;
        }
        if(i>arr.length-1){
            return Integer.MIN_VALUE;
        }
        if(ropeLength<0){
            return Integer.MIN_VALUE;
        }

        countA=countA+1+countRopeCuts(ropeLength-arr[i],arr,i);
        countB=countB+1+countRopeCuts(ropeLength-arr[i],arr,i+1);
        countC=countC+countRopeCuts(ropeLength,arr,i+1);
        return max(countA,countB,countC);
    }
    static int max(int a, int b, int c){
        return a>b?a>c?a:c:b>c?b:c;
    }
}
