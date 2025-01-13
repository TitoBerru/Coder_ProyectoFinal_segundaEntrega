package com.coderhouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "detalles_venta")
	public class DetalleVenta {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private Integer cantidad;

	    @Column(nullable = false)
	    private Double precioUnitario;

	    @Column(nullable = false)
	    private double subtotal;
	    
	    @ManyToOne
	    @JoinColumn(name = "venta_id", nullable = false)
	    private Venta venta;

	    @ManyToOne
	    @JoinColumn(name = "producto_id", nullable = false)
	    private Producto producto;

	 // Getters, Setters, Constructor, toString
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public double getPrecioUnitario() {
			return precioUnitario;
		}

		public void setPrecioUnitario(Double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}

		public double getSubtotal() {
			return this.cantidad * this.precioUnitario;
		}

		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
		}

		public Venta getVenta() {
			return venta;
		}

		public void setVenta(Venta venta) {
			this.venta = venta;
			if (!venta.getDetalles().contains(this)) {
		        venta.getDetalles().add(this);
		    }
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public DetalleVenta() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DetalleVenta(Long id, int cantidad, double precioUnitario, double subtotal, Venta venta,
				Producto producto) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
			this.subtotal = subtotal;
			this.venta = venta;
			this.producto = producto;
		}

		@Override
		public String toString() {
			return "DetalleVenta [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
					+ ", subtotal=" + subtotal + ", venta=" + venta + ", producto=" + producto + "]";
		}
		
		
	    
	    
	}


