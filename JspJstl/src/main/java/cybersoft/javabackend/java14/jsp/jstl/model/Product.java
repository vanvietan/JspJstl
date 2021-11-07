package cybersoft.javabackend.java14.jsp.jstl.model;

public class Product {
	//Properties
	
		private String id;
		private String name; 
		private String description;
		private float price;
		private int stock;
		
		//Constructors
		public Product() {
			
		}
		
		public Product(String id, String name, String description, float price, int stock) {
			this.id = id;
			this.description = description;
			this.name = name;
			this.price = price;;
			this.stock = stock;
		}

		//Getters & Setters
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		
		
}

