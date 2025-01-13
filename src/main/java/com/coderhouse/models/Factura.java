package com.coderhouse.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas") 
public class Factura {
	
	
	@Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para volverlo autoincremental
	private Long id;
	
	 @Column(nullable = false, unique = true)
	 private String numeroFactura;
	
	@Column (nullable = false)
	private LocalDate fechaVenta;
	
	@OneToMany(mappedBy= "factura", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Producto> productos = new ArrayList<>();

	// Constructores
	
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Factura(Long id, String numeroFactura, LocalDate fechaVenta, List<Producto> productos) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.fechaVenta = fechaVenta;
		this.productos = productos;
	}
	
	//Getters, Setters y ToString

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numeroFactura=" + numeroFactura + ", fechaVenta=" + fechaVenta + ", productos="
				+ productos + "]";
	}
	
	 
	}
