package com.telefonica.jee.service;

import java.util.List;
import java.util.Optional;

import com.telefonica.jee.model.Product;

/**
 * Service Interface for managing Product.
 */
public interface ProductService {

	/**
	 * Save a product
	 * @param product
	 * @return
	 */
	Product save(Product product);
	
	/**
	 * Get all products
	 * @return
	 */
	List<Product> findAll();
	
	/**
	 * Get one product by id
	 * @param id
	 * @return
	 */
	Optional<Product> findOne(Long id);
	
	/**
	 * It deletes one product by id
	 * @param id
	 */
	void delete(Long id);
}
