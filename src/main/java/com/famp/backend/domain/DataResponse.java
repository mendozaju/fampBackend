package com.famp.backend.domain;

import java.util.List;

import com.famp.backend.domain.ProductBean;;

public class DataResponse {
	
	List<ProductBean> data;

	public List<ProductBean> getData() {
		return data;
	}

	public void setData(List<ProductBean> data) {
		this.data = data;
	}

}
