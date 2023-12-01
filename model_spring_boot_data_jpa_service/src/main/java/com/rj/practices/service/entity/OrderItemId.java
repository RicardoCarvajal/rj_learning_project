package com.rj.practices.service.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idItem;

	private Integer idOrder;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem, idOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return idItem == other.idItem && idOrder == other.idOrder;
	}

}