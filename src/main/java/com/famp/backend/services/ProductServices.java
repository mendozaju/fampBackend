package com.famp.backend.services
;

import java.util.ArrayList;
import java.util.Iterator;

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
	ApplicationContext applicationContext;
	
	
	public ProductServices() {
		applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
	}
	
	
	public ArrayList<ProductBean> getProducts(){		
		
		Mapper mapper = (Mapper) applicationContext.getBean("mapper");
		ArrayList<ProductBean> result = new ArrayList<ProductBean>();
		
		ArrayList<Product> productsOfRepository = (ArrayList<Product>) repository.findAll();
		Iterator<Product> it = productsOfRepository.iterator();
		
		while(it.hasNext()){
			ProductBean myProduct = mapper.map(it.next(), ProductBean.class);
			result.add(myProduct);			
		}
		
		return result;		
	}

}
