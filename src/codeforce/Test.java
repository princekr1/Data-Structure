package codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        char arr[]={'A','B','C','D','E','F','G'};
        for(int j=0;j<t;j++){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            String problemString=scanner.next();
            int count=0;
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<problemString.length();i++){
                if(map.containsKey(problemString.charAt(i))){
                    int value=map.get(problemString.charAt(i))+1;
                    map.put(problemString.charAt(i),value);
                }else{
                    map.put(problemString.charAt(i),1);
                }
            }
            for(int i=0;i<arr.length;i++){
                if(map.containsKey(arr[i])){
                    if(map.get(arr[i])<m){
                        count=count+m-map.get(arr[i]);
                    }
                }else{
                    count=count+m;
                }
            }
            System.out.println(count);
        }
    }
}
