package com.famp.backend.controlers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
class FooController {
	//@Autowired
	//IFooService service;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public String miTest(){
		System.out.println("El controlado funca");
		return "pepe";
	}
	
	@RequestMapping(value="/persona")
	@ResponseBody
	public String miTest2(){
		System.out.println("El controlador 2  funca");
		return "{\"employees\": [{ \"firstName\":\"John\" , \"lastName\":\"Doe\" },{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" },{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" }]}";
	}
	/*@ResponseBody
	public List<Foo> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo get(@PathVariable("id") Long id) {
		return RestPreconditions.checkNotNull(service.getById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody Foo entity) {
		RestPreconditions.checkNotNullFromRequest(entity);
		return service.create(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Foo entity) {
		RestPreconditions.checkNotNullFromRequest(entity);
		RestPreconditions.checkNotNull(service.getById(entity.getId()));
		service.update(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}*/
}
