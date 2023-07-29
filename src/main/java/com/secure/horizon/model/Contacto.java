package com.secure.horizon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fechaCreacion;
	private String userName;
	private String message;
	
	//constructors
	public Contacto(int id, Date fechaCreacion, String userName, String message) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.userName = userName;
		this.message = message;
	}
	
	public Contacto() {
		super();
	}
	

	//getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	//pre persist
	@PrePersist
	public void fechaCreacionSetter() {
		this.fechaCreacion = new Date();
	}
}
