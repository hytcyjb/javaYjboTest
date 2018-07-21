package filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DealEncodeUtil extends HttpServletRequestWrapper {
	HttpServletRequest mrequest;
	public DealEncodeUtil(HttpServletRequest request) {
		super(request);
		mrequest = request;
	}

	@Override
	public String getParameter(String name) {
		try {
			mrequest.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String nameParam = mrequest.getParameter(name);
		
		return nameParam;
	}

}
