package cybersoft.javabackend.java14.jsp.jstl.servlet;

import java.io.IOException;
import java.sql.Connection;

import cybersoft.javabackend.java14.jsp.jstl.datasource.MySQLConnection;
import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="healthServlet", urlPatterns= {
		UrlConst.HEALTH,
		UrlConst.DB_CHECK
})
public class HealthServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		switch (path) {
		case UrlConst.HEALTH:
			
			break;
		case UrlConst.DB_CHECK:
			Connection testConnection = MySQLConnection.getConnection();
			if(testConnection != null) {
				resp.getWriter().append("Kết nối đến cơ sở dữ liệu thành công.");
			} else {
				resp.getWriter().append("Kết nối đến cơ sở dữ liệu thất bại.");
			}
			break;
		default:
			break;
		}
	}
}
