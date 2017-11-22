package my.fileutils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义一个实现文件拷贝的工具类，该类只负责具体的拷贝功能实现
 * 
 * @author Administrator
 *
 */
class CopyUtil implements Closeable {
	private InputStream input; // 输入流负责内容输入
	private OutputStream output; // 输出流进行输出

	/**
	 * 实例化拷贝工具类对象，该类要根据给出的输入流和输出流实现数据的读取与写入
	 * 
	 * @param input
	 *            包含有输入数据的输入流对象
	 * @param output
	 *            输出流对象
	 */
	public CopyUtil(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * 进行拷贝处理操作
	 * 
	 * @return 返回拷贝操作所花费的时间
	 * @throws IOException
	 *   IO的处理异常
	 */
	public long copy() throws IOException {
		long start = System.currentTimeMillis();
		byte data[] = new byte[2048]; // 每一次读取2048个内容
		int temp = 0; // 保存每一个读取的字节数据
		// 将每一次读取的内容保存到字节数组里面，而后返回的是读取的个数
		while ((temp = this.input.read(data)) != -1) {
			this.output.write(data, 0, temp); // 输出一组字节
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	@Override
	public void close() throws IOException {
		this.input.close();
		this.output.close();
	}
}

public class FileCopy {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("对不起，程序命令错误：CopyDemo 源文件路径 目标文件路径");
			System.exit(1); // 程序退出
		}
		File inFile = new File(args[0]); // 第一个参数为输入源文件
		if (!inFile.exists()) { // 源文件不存在
			System.out.println("对不起，您输入的源文件不存在，无法实现拷贝处理。");
			System.exit(1);
		}
		File outFile = new File(args[1]); // 第二个参数为输出的目标文件
		if (!outFile.getParentFile().exists()) { // 目标的父路径不存在
			outFile.getParentFile().mkdirs(); // 创建父路径
		}
		CopyUtil cu = new CopyUtil(new FileInputStream(inFile), new FileOutputStream(outFile));
		System.out.println("拷贝完成，所花费时间：" + cu.copy());
		cu.close();
	}
}