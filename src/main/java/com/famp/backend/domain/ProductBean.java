package com.famp.backend.domain;

public class ProductBean {
	
	Integer id;
	String description;
	Double price;
	
	public ProductBean(){
		this.id = null;
		this.description = "";
		this.price = null;
	}
	
	public void setDescription(String productDescription){
		this.description =productDescription;
	}
	
	public void setId(Integer productId){
		this.id = productId;
	}
	
	public void setPrice(Double productPrice){
		this.price= productPrice;		
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public Double getPrice(){
		return this.price;
	}
	

}
