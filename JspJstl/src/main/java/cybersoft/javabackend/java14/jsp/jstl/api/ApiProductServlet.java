package cybersoft.javabackend.java14.jsp.jstl.api;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import cybersoft.javabackend.java14.jsp.jstl.model.Product;
import cybersoft.javabackend.java14.jsp.jstl.service.ProductService;
import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="apiProductServlet" ,urlPatterns= {
		UrlConst.API_PRODUCT_GETALL,
		UrlConst.API_PRODUCT_ADD,
		UrlConst.API_PRODUCT_REMOVE
})
public class ApiProductServlet extends HttpServlet{
	
	ProductService service;
	Gson gson;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProductService();
		gson = new Gson();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("application/json");
		
		switch(path) {
		case UrlConst.API_PRODUCT_GETALL:
			List<Product> products = service.getProducts();
			resp.getWriter().append(gson.toJson(products));
			
			break;
		default:
			
			break;
		}
	}
}
