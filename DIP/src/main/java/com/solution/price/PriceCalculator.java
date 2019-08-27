package com.solution.price;

import com.solution.Product;

import java.math.BigDecimal;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public interface PriceCalculator {
    BigDecimal price(Product product);
}
