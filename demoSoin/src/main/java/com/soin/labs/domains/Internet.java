package com.soin.labs.domains;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Internet extends Product {

	@Column(name = "velocity")
	private Integer velocity;

	public Internet(int id, String description) {
		super(id, description);
	}

	public Internet() {
	}

	public Integer getVelocity() {
		return velocity;
	}

	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}
}
