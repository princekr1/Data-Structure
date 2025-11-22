package walmart;

public class MatrixSearch {

    public static void main(String arg[]){

        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 9;
        searchMatrix(matrix, target);
    }

    private static void searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 ||matrix[0].length==0){
            System.out.println("target not found, matrix empty");
            return;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int i=0,j=cols-1;

        while(i<rows && j<cols){
            if(matrix[i][j]==target){
                System.out.println("target found at i:"+i+", j: "+j);
                return;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("target not found : "+target);
    }
}
