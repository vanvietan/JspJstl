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

@WebFilter (urlPatterns= {
		UrlConst.ROOT
})
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		boolean isAuthed = req.getSession().getAttribute("isAuthenticated") 
				!= null? true : false;
		
		if(isAuthed) { 		//nếu đăng nhập rồi thì cho qua
			chain.doFilter(req, resp);
		}else if(UrlConst.LOG_IN.equals(req.getServletPath())){
			//Nếu chưa đăng nhập và truy cập trang đăng nhập thì cho qua 
			chain.doFilter(req, resp);
		}else { 		//Nếu chưa đăng nhập và truy cập trang khác thì bắt đăng nhập 
			resp.sendRedirect(req.getContextPath() + UrlConst.LOG_IN);
		}
	}

}
