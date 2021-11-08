package cybersoft.javabackend.java14.jsp.jstl.servlet;

import java.io.IOException;

import cybersoft.javabackend.java14.jsp.jstl.util.JspConst;
import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="authServlet", urlPatterns= {
		UrlConst.LOG_IN,
		UrlConst.LOG_OUT
})
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.AUTH_LOGIN).forward(req, resp);;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("adminadmin".equals(password + username)) {
			req.getSession().setAttribute("fullname", "Admin");
			req.getSession().setAttribute("isAuthenticated", true);
			resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
		}else  {
			resp.sendRedirect(req.getContextPath() + UrlConst.LOG_IN);
		}
	}
}
