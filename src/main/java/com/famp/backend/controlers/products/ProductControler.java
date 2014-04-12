package com.famp.backend.controlers.products;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.famp.backend.domain.ProductBean;
import com.famp.backend.services.ProductServices;

@Controller
@RequestMapping(value="/products")
public class ProductControler {
	
	@Autowired
	ProductServices service;
	
	
	@RequestMapping(value="/all")
	@ResponseBody
	public ArrayList<ProductBean> getProducts(HttpServletResponse response){
		
		ArrayList<ProductBean> products = new  ArrayList<ProductBean>();
		
		
		ProductBean myProduct = new ProductBean();
		myProduct.setDescription("Mi product");
		myProduct.setPrice(10.20);
		myProduct.setId(1);
		
		ProductBean myProduct2 = new ProductBean();
		myProduct2.setDescription("Mi product 2");
		myProduct2.setPrice(10.20);
		myProduct2.setId(1);
		
		products.add(myProduct);
		products.add(myProduct2);
		
		//ArrayList<ProductBean> productos = service.getProducts();		
		return products;
		
		
	}

}
