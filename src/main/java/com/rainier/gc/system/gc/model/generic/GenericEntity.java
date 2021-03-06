package com.rainier.gc.system.gc.model.generic;

import java.io.Serializable;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Generic Entity , every entity class needs to be override.
 *
 * @param <E> type Generic Entity
 */
public abstract class GenericEntity<K extends Serializable & Comparable<K>, E extends GenericEntity<K, ?>>
		implements Serializable, Comparable<E> {

	private static final long serialVersionUID = -3988499137919577054L;
	
	
	public abstract K getId();

	public abstract void setId(K id);

	@JsonIgnore
	public boolean isNew() {
		return getId() == null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		
		if (Hibernate.getClass(object) != Hibernate.getClass(this)) {
			return false;
		}
		GenericEntity<K, E> entity = (GenericEntity<K, E>) object;  
		K id = getId();
		if (id == null) {
			return false;
		}
		return id.equals(entity.getId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		
		K id = getId();
		hash = 31 * hash + ((id == null) ? 0 : id.hashCode());

		return hash;
	}

	public int compareTo(E o) {
		if (this == o) {
			return 0;
		}
		return this.getId().compareTo(o.getId());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("entity.");
		builder.append(Hibernate.getClass(this).getSimpleName());
		builder.append("<");
		builder.append(getId());
		builder.append("-");
		builder.append(super.toString());
		builder.append(">");
		
		return builder.toString();
	}
}