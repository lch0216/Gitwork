package com.yc.bean2_sort1.bubblesort;

public class BubbleSort {
	private int[] a;
	
	public BubbleSort( int[] a){
		this.a=a;
	}
	
	public void sort(){
		//��ѭ ������Ҫ�Ҽ������ֵ
		for(  int i=0;i<a.length-1;i++){
			//��ѭ������ѭ������
			for( int j=0;j<a.length-1-i;j++){
				if(  a[j]>a[j+1]){
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr={44,32,6,9,22};
		
		BubbleSort bs=new BubbleSort( arr );
		bs.sort();
		
		for( int t:arr){
			System.out.print(   t+"\t");
		}
	}
}
