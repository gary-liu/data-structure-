package com.mimi.datastruct.map;

public class BinarySeach {
	
	public static int binarySeach(int data[],int x,int low,int higt){
		if(x < data[low] || x > data[higt] || low > higt) return -1;
		int mid = (low + higt) /2;
		if(x < data[mid]){
			return binarySeach(data, x, low, mid - 1);
		}else if(x > data[mid]){
			return binarySeach(data, x, mid+1, higt);
		}else return mid;
	}
	
	public static int binarySearch(int data[],int x){
		int low = 0;
		int high = data.length - 1;
		
		while(low <= high){
			int mid = (low + high) / 2;
			if(x == data[mid]) return mid;
			else if(x < data[mid]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int data[]={6,12,45};
	}
}
