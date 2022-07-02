package com.productapp.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
	private Integer id;
	@Schema(description = "Product Name")
	@NotNull(message="{product.name.absent}")
	@Pattern(regexp ="[A-za-z]{5,50}", message="{product.name.invalid}")
	private String name;
	
	@Schema(description = "Product Price")
	@NotNull(message="{product.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
	private BigDecimal price;
	
	@Schema(description = "Product available or not?")
	private boolean isAvailable;
	
	public ProductDto(String name, BigDecimal price, boolean isAvailable) {
		super();
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	
	
	
	
}
