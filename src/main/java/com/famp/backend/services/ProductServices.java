package com.famp.backend.services
;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.famp.backend.domain.ProductBean;
import com.famp.backend.services.entities.Product;
import com.famp.backend.services.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository repository;	
	ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml");
	Logger log = Logger.getLogger(ProductServices.class.getName());
	
	
	public ProductServices() {
	}
	
	
	public List<ProductBean> getProducts(){
		log.info("Inicio de metodo");
		
		List<Product> entityProducts = repository.findAll();
		Iterator<Product> it = entityProducts.iterator();
		
		List<ProductBean> response = new ArrayList<ProductBean>(); 
		
		while(it.hasNext()){
			
			Product myEntityProduct= it.next();
			
			ProductBean product = (ProductBean) context.getBean("product");
			product.setId(myEntityProduct.getId());
			product.setName(myEntityProduct.getName());
			product.setPrice(myEntityProduct.getPrice());
			product.setStock(myEntityProduct.getStock());
			
			response.add(product);
		}
		
		log.info("Fin de metodo");
		return response;		
	}

}
