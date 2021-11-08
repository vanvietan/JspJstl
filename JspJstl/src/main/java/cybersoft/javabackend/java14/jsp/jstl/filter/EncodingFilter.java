package cybersoft.javabackend.java14.jsp.jstl.filter;

import java.io.IOException;

import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= {
		UrlConst.ROOT
})
public class EncodingFilter  implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//Code được thực hiện khi nhận request
		req.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, resp);
		
		//Code được thực hiện khi trả reponse
		resp.setCharacterEncoding("UTF-8");
	}
	
	
	
}
