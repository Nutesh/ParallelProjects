package com.cg.presentation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.Product;
import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoImpl;
import com.cg.utility.SortByName;
import com.cg.utility.SortByPrice;

public class MainUI {
   
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductDao dao=new ProductDaoImpl();
		List<Product> productlist=dao.getAllProducts();
		display(productlist);
		for(Product product : productlist)
		{
			System.out.println(product);
			
		}
		System.out.println("Enter Option 1.Sort by name. \n 2. Sort by Price.");
		int option = scanner.nextInt();
		switch(option)
		{
		case 1:{
			List<Product> productlistbyname=dao.getAllProducts();
			Collections.sort(productlistbyname, new SortByName());
			display(productlistbyname);
			
		}
		break;
		case 2:{
			List<Product> productlistbyprice=dao.getAllProducts();
			Collections.sort(productlistbyprice, new SortByPrice());
			display(productlistbyprice);
			
		}
		break;
	}
		
	}
	static void display(List<Product> productlist)
	{
		for(Product product : productlist) {
			System.out.println(product);
		}
	}
}
