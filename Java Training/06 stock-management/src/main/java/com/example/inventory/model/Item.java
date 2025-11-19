package com.example.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item {
	private Long id;
	private String name;
	private String description;
	private BigDecimal unitPrice;
	private Integer quantity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Item() {
	}

	public Item(String name, String description, BigDecimal unitPrice, Integer quantity) {
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
