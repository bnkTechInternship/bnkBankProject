package com.service.hotplace.domain.place;

public class Market {
	String category;
	String idx;
	
	public Market() {}

	public Market(String category, String idx) {
		super();
		this.category = category;
		this.idx = idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Market [category=" + category + ", idx=" + idx + ", getCategory()=" + getCategory() + ", getIdx()="
				+ getIdx() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
