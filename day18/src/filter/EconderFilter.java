package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ˣ�������ת�� @WebFilter("/EconderFliler")
 * 
 * @author yjbo
 * @Time 2018��2��4��12:51:04
 */
public class EconderFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EconderFilter����1");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	@Override
	public void destroy() {

	}

}
