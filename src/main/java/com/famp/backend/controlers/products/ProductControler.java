package com.famp.backend.controlers.products;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.famp.backend.domain.DataResponse;
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
	public DataResponse getProducts(HttpServletResponse response){
		log.info("Inicio del metodo");
		
		//Creo la respuesta
		DataResponse dataResponse = (DataResponse)context.getBean("dataResponse");
		
		//Obtengo todos los productos del servicio
		List<ProductBean> products =  service.getProducts();
		
		dataResponse.setData(products);
		
		log.info("Fin del metodo");
		//Retorno los productos
		return dataResponse;		
	}

}
