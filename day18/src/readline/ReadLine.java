package readline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 将其他java文件类读取并复制到电脑别的位置，使用了bufferReader
 * 
 * @author yjbo
 * @Time 2018年2月4日11:40:17
 */
public class ReadLine {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("src/readline/UpdateCustomerServlet.java");
		BufferedReader br = new BufferedReader(fr);
		String ch = null;
		String content="";
		int i = 0;
		while ((ch = br.readLine()) != null) {
			i++;
			content += (i + ":" + ch)+"\r\n";
			// ch=br.readLine的，这里我输出俩遍让大家看清楚，我原先天真的俩者相等，输出应该是没有问题的，但是如果我只输出第二句话的话，
			// 其实实在ch的基础上又跳到了下一句，图1中是我test.txt文件中的数据，他就会输出
		}
		System.out.println(content);
		if (content != null) {
			writeFileByName("C:/copyReadLine.java", content);
		} else {
			writeFileByName("C:/copyReadLine.java", "没有复制成功");
		}
	}

	public static void writeFileByName(String filename, String content) {
		File docFile = new File(filename);
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			p.println(content);
			txtfile.close();
			p.close();
			System.out.println("你好啊");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
