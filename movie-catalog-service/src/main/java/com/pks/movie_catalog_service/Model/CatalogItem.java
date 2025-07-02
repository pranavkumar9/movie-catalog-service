package com.pks.movie_catalog_service.Model;

public class CatalogItem {
	
	private String name;
	private String desc;
	private double rating;
	
	public CatalogItem(String name,String desc,double rating)
	{
		this.name=name;
		this.rating=rating;
		this.desc=desc;
	}
	
	public CatalogItem(){}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "CatalogItem [name=" + name + ", desc=" + desc + ", rating=" + rating + "]";
	}
	
	

}
