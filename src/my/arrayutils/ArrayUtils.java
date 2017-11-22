package my.arrayutils;

public class ArrayUtils{
	/**
	 * 一维数组的转置
	 * @param temp 需要转置的数组
	 */
	public static void reverseArray(int[] temp) {
		int head = 0;
		int mid = temp.length / 2 ;
		int tail = temp.length - 1;
		for (int x = 0; x < mid; x++) {
			int data = temp[head];
			temp[head] = temp[tail];
			temp[tail] = data ;
			head ++ ;
			tail --;
		}
	}
	/**
	 * 一维数组的排序
	 * @param temp 需要排序的数组
	 */
	public static void sortArray(int[] temp) {
		for(int x = 1;x < temp.length;x ++) {
			for (int y = 0; y < temp.length - x; y++) {
				if(temp[y] > temp[y + 1]) {
					int data = temp[y];
					temp[y] = temp[y + 1];
					temp[y + 1] = data ;
				}
			}
		}
	}
	/**
	 * 一维数组的二分搜索
	 * @param temp 要搜索的数组
	 * @param key 需要搜索的元素
	 * @return 需要搜索的元素的索引，搜索不到返回-1
	 */
	public static int binarySearch(int[] temp,int key) {
		int low = 0 ;
		int high = temp.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2 ;
			int midVal = temp[mid];
			if(midVal > key) {
				high = mid - 1;
			}else if(midVal < key){
				low =mid + 1;
			}else {
				return mid ;
			}
		}
		return -1;
		
	}
	/**
	 * 定义一个统计方法求数组中元素的最大值、最小值、数据总和、平均值。因为一个方法只能返回一种数据类型，可以用一个数组作为其方法的返回值
	 * @param tempv 需要统计的数组
	 * @return  数组[0]为最大值、数组[1]为最小值、数组[2]为数据总和、数组[3]为平均值
	 */
	public static double[] stat(int[] temp){
		double[] retDate = new double[4];
		retDate[0] = temp[0];
		retDate[1] = temp[0];
		retDate[2] = temp[0];
		 for(int x = 0;x < temp.length;x ++){
			retDate[2] += temp[x];
			if (temp[x] > retDate[0])
			{   
				retDate[0] = temp[x];
			}
			if (temp[x] < retDate[1])
			{
				retDate[1] = temp[x];
			}
		}
		retDate[3] = retDate[2]/temp.length;
		return retDate;
	}
	/**
	 * 一维数组的输出
	 * @param temp 需要输出的数组
	 */
	public static void printArraay(int[] temp) {
		for (int x = 0; x < temp.length; x++) {
			System.out.print(temp[x] + "、");
		}
		System.out.println();
	}
}