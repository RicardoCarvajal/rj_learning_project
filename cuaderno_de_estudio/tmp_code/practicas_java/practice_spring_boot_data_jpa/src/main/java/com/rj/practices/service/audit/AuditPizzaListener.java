package com.rj.practices.service.audit;

import org.springframework.util.SerializationUtils;

import com.rj.practices.service.entity.PizzaEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditPizzaListener {

	private PizzaEntity currentValue;

	@PostLoad
	public void postLoad(PizzaEntity entity) {
		System.out.println("POST LOAD");
		this.currentValue = SerializationUtils.clone(entity);// Esto se hace por el manejo de referencias de java, es
																// para evitarlo ya que estos son objetos complejos
	}

	@PostPersist
	@PostUpdate
	public void onPostPersist(PizzaEntity entity) {
		System.out.println("CREATE OR UPDATE");

		System.out.println("OLD: " + currentValue);
		System.out.println("NEW: " + entity);
	}

	@PreRemove
	public void onPreDelete(PizzaEntity entity) {
		System.out.println(entity);
	}

}
