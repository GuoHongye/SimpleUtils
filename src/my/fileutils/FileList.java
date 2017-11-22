package my.fileutils;

import java.io.File;

public class FileList {
	/**
	 * 该方法的主要目的是进行指定目录中的全部子目录和文件信息列出
	 * 
	 * @param file
	 *            当前要列出的目录
	 */
	public static void list(File file) {
		if (file.isDirectory()) { // 如果说现在给定的路径是一个目录，那么应该列出组成
			File result[] = file.listFiles(); // 列出全部的子目录（或文件）信息
			if (result != null) {
				for (int x = 0; x < result.length; x++) {
					list(result[x]); // 递归调用
				}
			}
		}
		System.out.println(file);
	}

	public static void main(String[] args) throws Exception {
		File file = new File("D:" + File.separator); // 假设这个是要操作的路径
		list(file);
	}

}
