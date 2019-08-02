package com.cg.repository;

import java.util.HashMap;

import com.cg.bean.Product;

public class ProductRepository {
	public static HashMap<Integer, Product> map=new HashMap<>();
	public static HashMap<Integer, Product> getAllProducts(){
		map.put(44,new Product(44,"laptop",50000));
		map.put(33,new Product(33,"computer",40000));
		map.put(22,new Product(22,"mobile",30000));
		map.put(55,new Product(55,"keyboard",500));
		map.put(11,new Product(11,"mouse",700));
		return map;
		
	}

}
