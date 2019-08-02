package com.cg.bean;

public class Product implements Comparable<Product>{   //implements comparing values
 private int pid;
 private String name;
 private double price;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Product(int pid, String name, double price) {
	super();
	this.pid = pid;
	this.name = name;
	this.price = price;
}
@Override
public String toString() {
	return  pid + "\t"+  name + "\t" + price ;
}
@Override
public int compareTo(Product p) {
	if(this.pid>p.pid)
	return 1;
	else if(this.pid<p.pid)
		return -1;
	else
		return 0;
	
}
 
}
