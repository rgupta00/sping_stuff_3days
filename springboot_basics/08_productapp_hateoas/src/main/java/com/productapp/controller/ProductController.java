package com.productapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;
import com.productapp.util.ConversionUtil;

@RestController
@RequestMapping(path = "api")
public class ProductController {

	private ProductService productService;

	public ProductController() {
	}

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/*
	 * 
	 * Spring boot + jpa+ basic crud operations + ResponseEntity
	 * 
	 * ResponseEntity is a bag which hold 2 things : data + http status code
	 */

	@GetMapping(path = "products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAll());
	}

	//CollectionModel : used when w want to return collection
	
	@GetMapping(path = "products-v2", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CollectionModel<ProductDto> getAllProductsV2() {
		//get all the products from db
		//convert that to List<ProductDto>
		List<ProductDto> products=productService.getAll().stream()
				.map(ConversionUtil::convertToProductDto)
				.collect(Collectors.toList());
		
		//for every product add the link
		for(ProductDto product: products) {
			Link link=linkTo(methodOn(ProductController.class)
					.getAnProductV2(product.getId()))
					.withSelfRel();
			product.add(link);
		}
		//return that CollectionModel
		
		return CollectionModel.of(products);
		//return ResponseEntity.ok(productService.getAll());
	}
	
	
	//EntityModel: is used when we have to return 1 object
	
	@GetMapping(path = "products-v2/{pid}")
	public EntityModel<ProductDto> getAnProductV2(@PathVariable(value = "pid") int id) {
		Link link=linkTo(methodOn(ProductController.class)
				.getAnProductV2(id))
				.withSelfRel();
		
		Product product = productService.getById(id);
		
		ProductDto dto=ConversionUtil.convertToProductDto(product);
		
		dto.add(link);
				
		//return new ResponseEntity<Product>(productService.getById(id), HttpStatus.OK);
		return EntityModel.of(dto);
	}

	
	@GetMapping(path = "products/{pid}")
	public ResponseEntity<Product> getAnProduct(@PathVariable(value = "pid") int id) {
		return new ResponseEntity<Product>(productService.getById(id), HttpStatus.OK);
	}

	@DeleteMapping(path = "products/{pid}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(value = "pid") int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/*
	 * 400 401 403
	 */
	// @Valid : will trigger some ex MethodArgumentNotValidException
	// 2. i have to define a hander for it
	@PostMapping(path = "products")
	public ResponseEntity<Product> postAnProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = ConversionUtil.convertToProduct(productDto);

		Product productAdded = productService.addProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
	}

	@PutMapping(path = "products/{pid}")
	public ResponseEntity<Product> updatedProduct(@Valid @RequestBody ProductDto productDto,
			@PathVariable(value = "pid") int id) {
		Product product = ConversionUtil.convertToProduct(productDto);
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}

}
