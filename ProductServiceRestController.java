package com.productservice.restcontroller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.jpa.entity.ProductService;
import com.productservice.jpa.r.ProductServicetRepository;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductServiceRestController {

	@Autowired
	public ProductServicetRepository productservicerepository;

	@PostMapping(value ="/product")
	public ProductService createProductService(@RequestBody ProductService productservice) {
		try {
			productservicerepository.save(productservice);
			return productservice;
		}catch(Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/product/{id}")
	public ResponseEntity<ProductService> getproductServiceById(@PathVariable("id") Long id) {
		Optional <ProductService> ps = productservicerepository.findById(id);
		if(ps.isPresent()) {
			return new ResponseEntity<ProductService>(ps.get(),HttpStatus.OK);

		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<ProductService> updateProductService(@PathVariable(value = "id") Long id,@RequestBody ProductService productservice){
		Optional<ProductService> productServicebyId = productservicerepository.findById(id);
		if(productServicebyId.isPresent()) {
			ProductService ps1 =new ProductService();
			
			ps1.setProductname(productservice.getProductname());
			
			ps1.setProductdescription(productservice.getProductdescription());
			
			ps1.setProductprice( productservice.getProductprice());
			
			productservicerepository.save(ps1);
			return new ResponseEntity<ProductService>(ps1,HttpStatus.OK);
			} else {
			return new ResponseEntity<ProductService>(HttpStatus.NOT_FOUND);
		}
			}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteProductService(@PathVariable Long id) {
		try {
			Optional<ProductService> ps21 = productservicerepository.findById(id);
			if (ps21.isPresent()) {
				productservicerepository.delete(ps21.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PatchMapping("/product/{id}/{productname}")
	public ResponseEntity<ProductService > updateProductServicePartially(@PathVariable Long id, String productname) {
		try {
			ProductService productservice= productservicerepository.findById(id).get();
			productservice.setProductname(productname);
			return new ResponseEntity<ProductService>(productservicerepository.save(productservice), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}