package com.solution.store;

import com.solution.Product;
import com.solution.data.MemoryDataStore;
import com.solution.price.DiscountPriceCalculator;
import com.solution.price.ExclusivePriceCalculator;
import com.solution.price.PriceCalculator;

import java.math.BigDecimal;

public class Store {

	private MemoryDataStore<Product> memoryDataStore = new MemoryDataStore<>();
	private PriceCalculator priceCalculator;

	public Store(PriceCalculator priceCalculator) {
		this.priceCalculator = priceCalculator;
	}

	public void open() {
		memoryDataStore.add(new Product("Book", new BigDecimal("100")));
		memoryDataStore.add(new Product("UberLaptop", new BigDecimal("10000")));
	}

	public void printPrices() {
		for (Product product : memoryDataStore.list()) {
			BigDecimal price = priceCalculator.price(product);
			System.out.println(product.getName() + ": " + price);
		}
	}

	public BigDecimal stock() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : memoryDataStore.list()) {
			BigDecimal price =priceCalculator.price(product);
			sum = sum.add(price);
		}
		return sum;
	}

}
