package readline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * ������java�ļ����ȡ�����Ƶ����Ա��λ�ã�ʹ����bufferReader
 * 
 * @author yjbo
 * @Time 2018��2��4��11:40:17
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
			// ch=br.readLine�ģ���������������ô�ҿ��������ԭ�������������ȣ����Ӧ����û������ģ����������ֻ����ڶ��仰�Ļ���
			// ��ʵʵ��ch�Ļ���������������һ�䣬ͼ1������test.txt�ļ��е����ݣ����ͻ����
		}
		System.out.println(content);
		if (content != null) {
			writeFileByName("C:/copyReadLine.java", content);
		} else {
			writeFileByName("C:/copyReadLine.java", "û�и��Ƴɹ�");
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
			System.out.println("��ð�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
