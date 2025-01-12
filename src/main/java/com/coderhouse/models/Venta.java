package com.coderhouse.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas") 
public class Venta {
	
	
	@Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para volverlo autoincremental
	private Long id;
	
	private Date fechaVenta;
	
	@Column(unique = true, nullable = false)
	private Long idProducto;
	
	private Long idCliente;
	
	@Column(nullable = false)
	private int precioVentaProducto;
	private int cantidadProducto;
	
	
	// Constructores
	
	public Venta() {
		super();
		
	}
	
	

	public Venta(Long idProducto, Long idCliente, int precioVentaProducto, int cantidadProducto) {
		super();
		this.idProducto = idProducto;
		this.idCliente = idCliente;
		this.precioVentaProducto = precioVentaProducto;
		this.cantidadProducto = cantidadProducto;
	}



	public Venta(Long id, Date fechaVenta, Long idProducto, Long idCliente, int precioVentaProducto,
			int cantidadProducto) {
		this();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.idProducto = idProducto;
		this.idCliente = idCliente;
		this.precioVentaProducto = precioVentaProducto;
		this.cantidadProducto = cantidadProducto;
	}
		// Getters and settes
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public int getPrecioVentaProducto() {
		return precioVentaProducto;
	}

	public void setPrecioVentaProducto(int precioVentaProducto) {
		this.precioVentaProducto = precioVentaProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fechaVenta=" + fechaVenta + ", idProducto=" + idProducto + ", idCliente="
				+ idCliente + ", precioVentaProducto=" + precioVentaProducto + ", cantidadProducto=" + cantidadProducto
				+ "]";
	}

}
