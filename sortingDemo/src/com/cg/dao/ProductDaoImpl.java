package com.cg.dao;

import java.util.ArrayList;
import com.cg.bean.Product;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import com.cg.repository.ProductRepository;

public class ProductDaoImpl implements ProductDao {

	public List<Product> getAllProducts() {
		HashMap<Integer,Product>map=ProductRepository.getAllProducts();
		Collection<Product> collection=map.values();
		List<Product> productlist =new ArrayList<>();
		productlist.addAll(collection);
		Collections.sort(productlist);
		return productlist;
	}

}
