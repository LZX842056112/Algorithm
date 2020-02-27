package com.atguigu.binarysearchnorecursion;
/**
 * @author 李宗效
 * @data 2020年2月27日下午6:43:18
 * 二分查找算法
 */
public class BinarySearchNoRecur {
	public static void main(String[] args) {
		//测试
		int[] arr = {1,3, 8, 10, 11, 67, 100};
		//二分查找的递归实现
		int index1 = binarySearch(arr, 0, arr.length - 1, 3);
		System.out.println("index1=" + index1);
		//二分查找的非递归实现
		int index2 = binarySearch(arr, 3);
		System.out.println("index2=" + index2);
	}
	
	/**
	 * 二分查找的递归实现
	 * @param arr 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param findVal 要查找的值
	 * @return 如果找到就返回下标，如果没有找到，就返回 -1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {//向右递归
			return binarySearch(arr, mid + 1, right, findVal);
		}else if(findVal < midVal){//向左递归
			return binarySearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}
	
	/**
	 * 二分查找的非递归实现
	 * @param arr 待查找的数组, arr是升序排序
	 * @param target 需要查找的数
	 * @return 返回对应下标，-1表示没有找到
	 */
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {//说明继续查找
			int mid = (left + right) / 2;
			if (target == arr[mid]) {
				return mid;
			}else if (target > arr[mid]) {//需要向右边查找
				left = mid + 1;
			}else {//需要向左边查找
				right = mid - 1;
			}
		}
		return -1;
	}
}
