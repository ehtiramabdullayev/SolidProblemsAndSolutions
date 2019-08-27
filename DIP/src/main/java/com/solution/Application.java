package com.solution;

import com.solution.price.DiscountPriceCalculator;
import com.solution.price.ExclusivePriceCalculator;
import com.solution.store.Store;

public class Application {

	public void startDefault() {
		System.out.println("Default store: ");
		Store store = new Store(new DiscountPriceCalculator());
		store.open();
		store.printPrices();
		System.out.println("Stock: " + store.stock());
	}

	public void startExclusive() {
		System.out.println("Exclusive store: ");
		Store store = new Store(new ExclusivePriceCalculator());
		store.open();
		store.printPrices();
		System.out.println("Stock: " + store.stock());
	}

	public static void main(String[] args) {
		new Application().startDefault();
		System.out.println();
		new Application().startExclusive();
	}
}
