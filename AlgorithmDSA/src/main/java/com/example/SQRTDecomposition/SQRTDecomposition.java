package com.example.SQRTDecomposition;

import java.util.List;

public class SQRTDecomposition {

	
	public static void main(String[] args) {
	int [] arr = {1,3,5,2,7,6,3,1,4,8};
	
	int n = arr.length;
	
	int sqrt = (int) Math.sqrt(n);
	
	int blocks_id = -1;
	
	int[] blocks = new int[sqrt +1];
	
	for(int i=0; i<n; i++) {
		//blocks starting
		if(i%sqrt == 0) {
			blocks_id ++;
		}
		
		blocks[blocks_id] += arr[i];
	}
	
	System.out.println(query(blocks, sqrt, arr, 2, 7));
	}
	public static int query(int[] blocks, int sqrt, int[] arr, int l, int r) {
		int ans =0;
	
		
		while(l%sqrt !=0 && l<r && l!=0){
			ans += arr[l];
			l++;
		}
		
		while(l + sqrt <= r) {
			ans += blocks[l/sqrt];
			l += sqrt;
		}
		
		while(l<=r) {
			ans +=arr[l];
			l++;
		}
		return ans;
	}
	
	public static void update(int[] blocks, int arr[], int i, int val, int sqrt){
		
		int block_id = i/sqrt;
		
		blocks[block_id] += (val - arr[i]);
		
		arr[i] = val;
	}
	
	}

