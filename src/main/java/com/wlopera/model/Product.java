package com.wlopera.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  // anotacion para convertirlo en XML -> Json
public class Product implements Serializable{
	
	private static final long serialVersionUID = -1883437301416426674L;
	
	private int id;
	private String nombre;
	private double cantidad;
	
	public Product() {}
	
	public Product(int id, String nombre, double cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
}
