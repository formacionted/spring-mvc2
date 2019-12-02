package com.telefonica.jee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.jee.model.Product;
import com.telefonica.jee.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
        log.debug("Request to get all Products");
        return productRepository.findAll();
	}

	@Override
	public Optional<Product> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
	}

}
