package Linklist;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0,max=0;
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println(str);
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='A'||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O'||str.charAt(i)=='U') {
				count=0;
				System.out.println("###########"+str.charAt(i)+"\t###3#");
				for(int j=i+1;j<str.length();j++) {
					count++;
					System.out.println("char: "+str.charAt(j)+"count:"+count);
					
					if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='A'||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O'||str.charAt(i)=='U') {
						System.out.println("inside if:"+str.charAt(j));
						if(str.charAt(j)!=' '){
								break;
						}
					}
					
				}
				
			}
			if(count>max) {
				max=count;
			}
		}
		System.out.println(max);
	}

}
