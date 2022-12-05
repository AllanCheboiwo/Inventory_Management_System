package Inventory_Management_System;
/**
 * A class to represent the different suppliers of the products
 */
public class Supplier {
	private String supplierName;
	private String supplierEmail;
	private String product;
	
	
	public Supplier(String supplierName, String supplierEmail, String product) {
		super();
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.product = product;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
	

}
