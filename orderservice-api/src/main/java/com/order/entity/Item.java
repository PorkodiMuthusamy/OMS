package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_item")
public class Item {
	
	@Id
	private Integer itemCode;

	@NotEmpty(message = "Please provide the Item Name")	
	private String itemName;
	
	private Integer quantity;
	
	public Integer getItemCode() {
		return itemCode;
	}

	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
