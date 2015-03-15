package com.ndsoft.cms.api;


import org.hibernate.type.BasicType;

public class DbParameter {
	private String name;
	private BasicType type;
	private Object value;

	public DbParameter() {

	}

	public DbParameter(String name,BasicType type,Object value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	
	public BasicType getType() {
		return type;
	}

	public void setType(BasicType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
