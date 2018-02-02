package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class JDBC_Information {
	private int goods_id;
	private String goods_name;
	private String goods_cate;
	private String brand_name;
	private Double goods_price;
	private int is_show;
	private int is_saleoff;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_cate() {
		return goods_cate;
	}

	public void setGoods_cate(String goods_cate) {
		this.goods_cate = goods_cate;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	public int getIs_show() {
		return is_show;
	}

	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}

	public int getIs_saleoff() {
		return is_saleoff;
	}

	public void setIs_saleoff(int is_saleoff) {
		this.is_saleoff = is_saleoff;
	}

}
