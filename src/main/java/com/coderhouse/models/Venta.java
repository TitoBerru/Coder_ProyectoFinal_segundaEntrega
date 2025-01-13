package com.coderhouse.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas") 
public class Venta {
	
	
	@Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para volverlo autoincremental
	private Long id;
	
	 @Column(nullable = false, unique = true)
	 private String numeroFactura;
	
	@Column (nullable = false)
	private LocalDate fechaVenta;
	
	 @Column(nullable = false)
	    private double totalVenta;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<DetalleVenta> detalles = new ArrayList<>();
	
	
	 
	 
	 // Constructores
	 
	 public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

	public Venta(Long id, String numeroFactura, LocalDate fechaVenta, Cliente cliente, List<DetalleVenta> detalles,
			double totalVenta) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.detalles = detalles;
		this.totalVenta = totalVenta;
	}

	

	// Getter and setters
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}


	// TO String
	@Override
	public String toString() {
		return "Venta [id=" + id + ", numeroFactura=" + numeroFactura + ", fechaVenta=" + fechaVenta + ", cliente="
				+ cliente + ", totalVenta=" + totalVenta + "]";
	}
	 
	 
	 
	}
