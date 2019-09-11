package com.springmvcone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	private List<Product> products=new ArrayList<>();
	
	
	public ProductRestController() {
		// TODO Auto-generated constructor stub
		
		products.add(new Product("1","Pen", 100));
		products.add(new Product("2","Marker", 150));
	}
	
	
	//@RequestMapping(path = "/products",method = RequestMethod.GET)
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return products;
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product p)
	{
		products.add(p);
	}
	
	@DeleteMapping("/products/{code}")
	public void delete(@PathVariable("code") String code)
	{
		boolean f=false;
		Product p=null;
		for (Product product : products) {
			if(product.getCode().equals(code))
			{
				f=true;
				p=product;
				break;
			}
		}
		if(f==true)
		{
			products.remove(p);
		}
	}
	
	@PutMapping("/products/{code}")
	public void update(@PathVariable("code") String code,@RequestBody Product p)
	{
		boolean f=false;
		Product c=null;
		for (Product product : products) {
			if(product.getCode().equals(code))
			{
				f=true;
				c=product;
				break;
			}
		}
		if(f==true)
		{
			c.setCode(p.getCode());
			c.setName(p.getName());
			c.setPrice(p.getPrice());
		} 
	}

}
