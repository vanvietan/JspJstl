package cybersoft.javabackend.java14.jsp.jstl.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import cybersoft.javabackend.java14.jsp.jstl.util.JspConst;
import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="homeServlet" , urlPatterns={
		UrlConst.HOME
})
public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//đọc thời gian lần cuối mà người dùng truy cập
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			System.out.printf("name[%s]: %s\n", c.getName(), c.getValue());
		}
		
		//Tạo cookie lưu trữ thời gian người dùng truy cập lần cuối
		Cookie cookie  = new Cookie("lastAccess",LocalDateTime.now().toString());
		cookie.setMaxAge(10);
		resp.addCookie(cookie);
		
		//Lưu thông tin người dùng vào session 
//		HttpSession session = req.getSession();
//		session.setAttribute("userid", "vietan");
//		session.setAttribute("fullname", "Nguyễn Văn Viết An");
//		session.setMaxInactiveInterval(60);
//		
//		System.out.printf("Fullname: %s\n" , String.valueOf(
//				session.getAttribute("fullname")));
//		session.getAttribute("fullname");
		
		
		req.getRequestDispatcher(JspConst.HOME).forward(req, resp);
	}
}
