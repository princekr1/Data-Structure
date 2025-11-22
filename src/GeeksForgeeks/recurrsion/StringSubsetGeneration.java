package GeeksForgeeks.recurrsion;

import java.util.Scanner;

/*Question : Generate Subsets: given a string with unique letters find all subsets
ex: String : "abc"
result : "a","b","c","ab","ac","bc","abc"*/
public class StringSubsetGeneration {

    public static void main(String args[]){
        System.out.println("Enter String : ");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        generateSubString(str,"",0);
    }

    private static void generateSubString(String str,String res, int i) {

        if(i>str.length()-1){
            return;
        }

        System.out.println(res+str.charAt(i));
        generateSubString(str,res,i+1);
        generateSubString(str,res+str.charAt(i),i+1);

    }
}
