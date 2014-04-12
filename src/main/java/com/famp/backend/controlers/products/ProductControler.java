package com.famp.backend.controlers.products;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.famp.backend.domain.ProductBean;
import com.famp.backend.services.ProductServices;

@Controller

public class ProductControler {
	
	static Logger log = Logger.getLogger(ProductControler.class.getName());
	ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml"); 
	
	@Autowired
	ProductServices service;
	
	@RequestMapping(value="/products")
	@ResponseBody
	public ArrayList<ProductBean> getProducts(HttpServletResponse response){
		log.info("Inicio del metodo");
		
		ArrayList<ProductBean> products = new  ArrayList<ProductBean>();		
		
		ProductBean myProduct1 = (ProductBean) context.getBean("product");
		myProduct1.setId(1);
		myProduct1.setName("Tablet Bangho XT45");
		myProduct1.setPrice(1200.59);
		myProduct1.setStock(10);	
		
		ProductBean myProduct2 = new ProductBean();
		myProduct2.setId(2);
		myProduct2.setName("Samsung Galaxy S4");
		myProduct2.setPrice(6399.29);
		myProduct2.setStock(400);
		
		ProductBean myProduct3 = new ProductBean();
		myProduct3.setId(3);
		myProduct3.setName("Monitor LED LG");
		myProduct3.setPrice(2600.0);
		myProduct3.setStock(15);
		
		products.add(myProduct1);
		products.add(myProduct2);
		products.add(myProduct3);
		
		log.info("Fin del metodo");
		return products;		
	}

}
