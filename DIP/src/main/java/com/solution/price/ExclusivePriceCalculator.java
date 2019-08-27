package com.solution.price;

import com.solution.Product;

import java.math.BigDecimal;

public class ExclusivePriceCalculator implements PriceCalculator {

	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("2"));
	}

}
