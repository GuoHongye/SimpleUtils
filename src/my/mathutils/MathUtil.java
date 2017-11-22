package my.mathutils;


public class MathUtil {
	private MathUtil() {} ;	// 构造方法私有化
	/**
	 * 进行准确位数的四舍五入处理操作
	 * @param num 要进行四舍五入计算的数字
	 * @param scale 保留的小数位
	 * @return 四舍五入处理后的结果
	 */
	public static double round(double num,int scale) {
		return Math.round(num * Math.pow(10.0, scale)) / Math.pow(10.0, scale) ;
	} 
}