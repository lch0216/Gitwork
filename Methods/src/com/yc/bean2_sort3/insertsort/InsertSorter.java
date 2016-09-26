package com.yc.bean2_sort3.insertsort;

import com.yc.bean2_sort2.selectionsort.SelectionSort;

public class InsertSorter {
	private int[] a;
	
	public InsertSorter( int[] a){
		this.a=a;
	}
	
	public void sort(){
		//��������ٶ�: ǰ���Ԫ�����Ѿ��ź���. 
		
		//�ٶ���һ��Ԫ�������Ѿ��ź����, �ӵڶ���Ԫ��ѭ��
		for( int i=1;i<a.length;i++){
			//ȡ����ǰ��ֵ
			int next=a[i];
			//��¼����
			int j=i;
			//ѭ��iǰ���Ԫ�أ���ǰ���Ԫ���Ƿ����  next
			while(   j>0 && a[j-1]  >next ){
				//����λ��
				a[j]=a[j-1];
				j--;
			}
			a[j]=next;
		}
	}
	
	public static void main(String[] args){
		int[] arr={44,32,6,9,22};
		
		InsertSorter bs=new InsertSorter( arr );
		bs.sort();
		
		for( int t:arr){
			System.out.print(   t+"\t");
		}
	}
}
