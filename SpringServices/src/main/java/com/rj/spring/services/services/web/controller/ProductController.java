package com.rj.spring.services.services.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.spring.services.services.domain.Product;
import com.rj.spring.services.services.domain.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/all")
	@ApiOperation("Obtener todos los productos del supermercado")
	@ApiResponse(code = 200, message = "Ok")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation("Obtener un producto por el ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 404, message = "Nor found") })
	public ResponseEntity<Product> getProduct(
			@ApiParam(value = "El ID del producto", required = true, example = "7") @PathVariable("id") int idProduct) {
		return productService.getProduct(idProduct).map(pro -> new ResponseEntity<>(pro, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/category/{idCategory}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("idCategory") int idCategory) {
		return productService.getByCategory(idCategory).map(pros -> new ResponseEntity<>(pros, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.save(product), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") int idProduct) {
		if (productService.delete(idProduct)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/scare/{qa}")
	public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("qa") int quantity) {
		return productService.getScarseProducts(quantity).map(pros -> new ResponseEntity<>(pros, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
