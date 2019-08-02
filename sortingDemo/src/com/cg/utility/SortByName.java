package com.cg.utility;

import java.util.Comparator;
import com.cg.bean.Product;

import com.cg.bean.Product;

public class SortByName implements Comparator<Product>{

	public int compare(Product p1,Product p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
