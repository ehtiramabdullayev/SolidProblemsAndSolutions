package com.solution.price;

import com.solution.Product;

import java.math.BigDecimal;

public class DiscountPriceCalculator implements PriceCalculator {

	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("0.9"));
	}

}
