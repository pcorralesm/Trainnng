package com.soin.labs.domains;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Phone extends Product {

	@Column(name = "model")
	private String model;

	public Phone(int id, String description) {
		super(id, description);
	}

	public Phone() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
