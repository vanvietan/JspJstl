package cybersoft.javabackend.java14.jsp.jstl.service;

import java.util.List;

import cybersoft.javabackend.java14.jsp.jstl.model.Product;
import cybersoft.javabackend.java14.jsp.jstl.repository.ProductRepository;

public class ProductService {
 
private ProductRepository repository;
	
	public ProductService() {
		repository = new ProductRepository();
	}
	
	/*
	 * Viết các chức năng sau:
	 */
	/* - addProduct:
	 * 	+ params: Product product
	 * 	+ return: boolean, true if added successfully
	 */
	public boolean addProduct(Product product) {
		/* validate product */
		
		
		return repository.addProduct(product) == 1 ? true : false;
	}
	
	/* - removeProduct:
	 * 	+ params: String productId
	 * 	+ return: boolean, true if removed successfully
	 */
	/**
	 * remove product from product list
	 * @param String productId
	 * @return boolean, true if removed successfully
	 */
	public boolean removeProduct(String productId) {
		
		return repository.removeProduct(productId) == 1 ? true : false;
	}
	
	/* - getProducts:
	 * 	+ params: no
	 * 	+ return: List<Product>
	 */
	public List<Product> getProducts(){
		return repository.getProducts();
	}
}
