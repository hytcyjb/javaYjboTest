package day08;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.jasper.tagplugins.jstl.core.Url;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 * @describe http://localhost:8080/day08/index.jsp
 * @author yjbo
 * @date 2017年12月11日 下午6:29:09
 */
public class HttpConn {

	public static void main(String[] args) throws IOException {
		HttpURLConnection urlConnection = null;
		URL url = new URL("http://localhost:8080/day08/index.jsp");
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		InputStream inputStream = urlConnection.getInputStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inputStream.read(buffer))>0){
			outputStream.write(buffer,0,len);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();
		System.out.println(outputStream.toString("UTF-8"));
	}

}
