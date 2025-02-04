package com.demo.wap;

public class ArmStrong {

	
	public static void main(String[] args) {
		int no =153;
		int temp = no;
		int leng=0;
		
		while(temp !=0) {
			
			temp = temp/10;
			leng = leng + 1;	
		}
		
		
		int t2= no;
		int rem;
		
		int arm =0;
		
		while( t2 !=0){
			int mul =1;
			rem = t2%10;
			
			for(int i =1; i<=leng; i++) {
				
				mul = mul * rem;
			}
			arm = arm+mul;
			
			t2= t2/10;
		}
		System.out.println(arm);
	}
}
