package Linklist;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str=sc.next();
		int []b=new int[n];
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(str.charAt(i)+"");
			
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++)
			{
				if(b[i]>b[j]) {
				int t=b[i];
				b[i]=b[j];
				b[j]=t;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println("no:"+b[i]);
			
		}
			
			
			
		
		
	}

}
