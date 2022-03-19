package com.movie.booking.entity;

public class OrderDetail {

	public String productName;
	public float subtotal;
	public float shipping;
	public float tax;
	public float total;

	public OrderDetail() {
	}

	public OrderDetail(String productName, float subtotal, float shipping, float tax, float total) {
		this.productName = productName;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSubtotal() {
		return String.format("%.2f",subtotal);
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public String getShipping() {
		return String.format("%.2f",shipping);
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public String getTax() {
		return String.format("%.2f",tax);
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getTotal() {
		return String.format("%.2f",total);
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
