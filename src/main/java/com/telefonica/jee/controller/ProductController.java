package com.telefonica.jee.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telefonica.jee.model.Product;
import com.telefonica.jee.service.ProductService;

@Controller
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * Punto de entrada a la aplicacion, con poner la URL donde escucha nuestra
	 * aplicacion entrará aquí y desde aquí redireccionamos al método para obtener
	 * todos los productos y cargar el listado
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String root() {
		return "redirect:/products";
	}

	@GetMapping("/products")
	public ModelAndView getAllProducts() {
		log.debug("request to get Products");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-list");
		mav.addObject("products", productService.findAll());
		return mav;
	}

	@GetMapping("/products/empty")
	public ModelAndView createProduct() {
		log.debug("request to empty product form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-edit");
		mav.addObject("product", new Product());
		return mav;
	}
	
	/**
	 * GET /products/:id : get the "id" product.
	 *
	 * @param id the id of the product to retrieve
	 * @return
	 */
	@GetMapping("/products/{id}")
	public ModelAndView getProduct(@PathVariable Long id) {
		log.debug("request to get Product : {}", id);
		Optional<Product> product = productService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (product.isPresent()) {
			mav.setViewName("product-edit");
			mav.addObject("product", product.get());
		} else {
			mav.setViewName("product-list");
			mav.addObject("message", "Product not found");
		}

		return mav;
	}

	/**
	 * GET /products/:id : get the "id" product.
	 *
	 * @param id the id of the product to retrieve
	 * @return
	 */
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		log.debug("request to save Product : {}", product);

		// El producto no existe y tenemos que crearlo
		if (product.getId() == null) {
			productService.save(product);
			return "redirect:/products";
		}

		// El producto ya existe y tenemos que actualizarlo
		Optional<Product> existingProductWrap = productService.findOne(product.getId());
		if (existingProductWrap.isPresent()) {

			Product existingProduct = existingProductWrap.get();
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
			productService.save(existingProduct);
		}
		return "redirect:/products";
	}

	/**
	 * /products/:id/delete : delete the "id" product.
	 *
	 * @param id the id of the product to delete
	 * @return
	 */
	@GetMapping("/products/{id}/delete")
	public String deleteProduct(@PathVariable Long id) {
		log.debug("request to delete Product : {}", id);
		productService.delete(id);
		return "redirect:/products" ;
	}
	

}
