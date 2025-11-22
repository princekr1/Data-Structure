package codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestString {

    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int j=0;j<t;j++){
            int n=scanner.nextInt();
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            int m=scanner.nextInt();
            for(int i=0;i<m;i++){
                String input=scanner.next();
                Map<Character,Integer> map=new HashMap<>();
                Map<Integer,Character> mapValue=new HashMap<>();
                boolean flag=true;
                if(input.length()>n || n>input.length()){
                    System.out.println("NO");
                    flag=false;
                }
                for(int k=0;k<n && input.length()<n+1 && n<input.length()+1;k++){
                    if(map.containsKey(input.charAt(k))){
                        int temp=map.get(input.charAt(k));

                        if(temp!=a[k]){
                            System.out.println("NO");
                            flag=false;
                            break;
                        }
                    } else if (mapValue.containsKey(a[k])) {
                        char c=mapValue.get(a[k]);
                        if(c!=input.charAt(k)){
                            System.out.println("NO");
                            flag=false;
                            break;
                        }
                    } else {
                        map.put(input.charAt(k),a[k]);
                        mapValue.put(a[k],input.charAt(k));
                    }
                }
                if(flag){
                    System.out.println("YES");
                }
            }
        }
    }
}
