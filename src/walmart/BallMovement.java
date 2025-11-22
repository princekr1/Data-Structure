package walmart;

public class BallMovement {

    public static int [] getCounts(String input){

        char []ch=input.toCharArray();

        int count=0;
        int moves=0;
        int []result=new int[ch.length];

        for(int i=0;i<ch.length;i++){
            result[i]=result[i]+moves;
            count+=ch[i]-'0';
            moves+=count;
        }
        count=0;
        moves=0;
        for(int i=ch.length-1;i>-1;i--){
            result[i]=result[i]+moves;
            count+=ch[i]-'0';
            moves+=count;
        }
        return result;

    }

    public static void main(String[] args) {

        String boxes = "110";
        int[] result = BallMovement.getCounts(boxes);

        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 1 1 3
    }
}
