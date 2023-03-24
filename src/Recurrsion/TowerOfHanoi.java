package Recurrsion;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char from, char to,char aux){
        if(n==1){
            System.out.println("moving " +n+" disk from "+from+ " to "+to );
            return;
        }else{
            //moving n-1 disc from A to B using c
            towerOfHanoi(n-1,from,aux,to);
            System.out.println("moving " +n+" disk from "+from+ " to "+to );
            //moving n-1 disc from aux to B
            towerOfHanoi(n-1,aux,to,from);
        }
    }
    public static void main(String args[]){
        TowerOfHanoi.towerOfHanoi(3,'A','C','B');
    }
}
