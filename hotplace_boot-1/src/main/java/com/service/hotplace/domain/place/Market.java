package com.service.hotplace.domain.place;

public class Market {
	// fields
	String category;
	String idx;
	
	// constructors
	public Market() {}
	public Market(String category, String idx) {
		super();
		this.category = category;
		this.idx = idx;
	}
	
	// getter
	public String getCategory() {return category;}
	public String getIdx() {return idx;}
	
	// setter
	public void setCategory(String category) {this.category = category;}
	public void setIdx(String idx) {this.idx = idx;}

	@Override
	public String toString() {
		return "Market [category=" + category + ", idx=" + idx + ", getCategory()=" + getCategory() + ", getIdx()="
				+ getIdx() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
