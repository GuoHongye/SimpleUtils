package my.stringutils;

public class StringUtil {
	/**
	 * 用于将指定字符串的首字母变为大写
	 * @param str 需要处理的字符串
	 * @return 处理 后的字符串
	 */

	public static String initcap(String str) {
		if (str == null || "".equals(str)) {// 没有数据或者字符串为空
			return str;// 不对字符串进行处理，进来是什么输出什么
		}
		if (str.length() > 1) {
			// 字符串长度大于1，返回第一个字符转为大写再连接剩下的字符
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		// 字符串长度小于1，返回str直接转为大写即可
		return str.toUpperCase();
	}
}
