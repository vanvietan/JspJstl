package cybersoft.javabackend.java14.jsp.jstl.servlet;

import java.io.IOException;

import cybersoft.javabackend.java14.jsp.jstl.model.Product;
import cybersoft.javabackend.java14.jsp.jstl.service.ProductService;
import cybersoft.javabackend.java14.jsp.jstl.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="productServlet", urlPatterns= {
		UrlConst.PRODUCT_HOME,
		UrlConst.PRODUCT_ADD,
		UrlConst.PRODUCT_REMOVE
		
})
public class ProductServlet extends HttpServlet {
	
	private ProductService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/products":
			req.setAttribute("products", service.getProducts());
			req.getRequestDispatcher("/WEB-INF/pages/product.jsp")
				.forward(req, resp);
			break;
		case "/products/remove":
			String deleteId = req.getParameter("id");
			service.removeProduct(deleteId);
			resp.sendRedirect(req.getContextPath() + "/products");
			break;
		case "/products/add":
			Product product = new Product();
			product.setId(req.getParameter("id"));
			product.setName(req.getParameter("name"));
			product.setDescription(req.getParameter("description"));
			product.setPrice(Float.parseFloat(req.getParameter("price")));
			product.setStock(Integer.parseInt(req.getParameter("stock")));
			service.addProduct(product);
			resp.sendRedirect(req.getContextPath() + "/products");
			break;
		default:
			break;
		}
	}
}
