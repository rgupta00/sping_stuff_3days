package com.productappclient.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_table_boot_exp2")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	
	@NotNull(message="{product.name.absent}")
	@Pattern(regexp ="[A-za-z]{5,50}", message="{product.name.invalid}")
	@Column(name = "product_name")
	private String name;
	
	@NotNull(message="{product.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
	@Column(name = "product_price")
	private BigDecimal price;
	
	@Column(name = "product_isavailable")
	private boolean isAvailable;
	
	public Product(String name, BigDecimal price, boolean isAvailable) {
		super();
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	
	
	
	
}
