package com.coderhouse.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para volverlo autoincremental
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombreProducto;

	@Column(length = 500)
	private String descripcionProducto;

	@Column(length = 50)
	private String categoriaProducto;

	@Column(length = 50)
	private String marcaProducto;

	@Column(length = 100)
	private String proveedorProducto;

	@Column(length = 200)
	private String imgUrlProducto;

	@Column(nullable = false)
	private int cantidadStockProducto;

	private int precioCompraProducto;

	@Column(nullable = false)
	private int precioVentaProducto;

	private int descuentoProducto;

	@Column(length = 3)
	private String monedaProducto;

	private Date fechaAltaProducto;
	private Date fechaModificacionProducto;

	@Column(nullable = false)
	private boolean estadoActivoProducto;

	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//			name = "producto_cliente", 
//			joinColumns = @JoinColumn(name= "producto_id"), 
//			inverseJoinColumns = @JoinColumn(name = "cliente_id"))

	private List<Cliente> clientes = new ArrayList<>();

	// Constructores
	public Producto() {
		super();
	}

	public Producto(String nombreProducto, int cantidadStockProducto, int precioCompraProducto, int precioVentaProducto,
			int descuentoProducto, boolean estadoActivoProducto) {
		this();
		this.nombreProducto = nombreProducto;
		this.cantidadStockProducto = cantidadStockProducto;
		this.precioCompraProducto = precioCompraProducto;
		this.precioVentaProducto = precioVentaProducto;
		this.descuentoProducto = descuentoProducto;
		this.estadoActivoProducto = estadoActivoProducto;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public String getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public String getProveedorProducto() {
		return proveedorProducto;
	}

	public void setProveedorProducto(String proveedorProducto) {
		this.proveedorProducto = proveedorProducto;
	}

	public String getImgUrlProducto() {
		return imgUrlProducto;
	}

	public void setImgUrlProducto(String imgUrlProducto) {
		this.imgUrlProducto = imgUrlProducto;
	}

	public int getCantidadStockProducto() {
		return cantidadStockProducto;
	}

	public void setCantidadStockProducto(int cantidadStockProducto) {
		if (cantidadStockProducto < 0) {
			throw new IllegalArgumentException("La cantidad en stock no puede ser menor a 0.");
		}
		this.cantidadStockProducto = cantidadStockProducto;
	}

	public int getPrecioCompraProducto() {
		return precioCompraProducto;
	}

	public void setPrecioCompraProducto(int precioCompraProducto) {
		if (precioCompraProducto < 0) {
			throw new IllegalArgumentException("El precio del producto no puede ser menor a 0.");
		}
		this.precioCompraProducto = precioCompraProducto;
	}

	public int getPrecioVentaProducto() {
		return precioVentaProducto;
	}

	public void setPrecioVentaProducto(int precioVentaProducto) {
		if (precioVentaProducto < 0) {
			throw new IllegalArgumentException("El precio de venta no puede ser menor a 0.");
		}
		this.precioVentaProducto = precioVentaProducto;
	}

	public int getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

	public String getMonedaProducto() {
		return monedaProducto;
	}

	public void setMonedaProducto(String monedaProducto) {
		this.monedaProducto = monedaProducto;
	}

	public Date getFechaAltaProducto() {
		return fechaAltaProducto;
	}

	public void setFechaAltaProducto(Date fechaAltaProducto) {
		this.fechaAltaProducto = fechaAltaProducto;
	}

	public Date getFechaModificacionProducto() {
		return fechaModificacionProducto;
	}

	public void setFechaModificacionProducto(Date fechaModificacionProducto) {
		this.fechaModificacionProducto = fechaModificacionProducto;
	}

	public boolean isEstadoActivoProducto() {
		return estadoActivoProducto;
	}

	public void setEstadoActivoProducto(boolean estadoActivoProducto) {
		this.estadoActivoProducto = estadoActivoProducto;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", descripcionProducto="
				+ descripcionProducto + ", categoriaProducto=" + categoriaProducto + ", marcaProducto=" + marcaProducto
				+ ", proveedorProducto=" + proveedorProducto + ", imgUrlProducto=" + imgUrlProducto
				+ ", cantidadStockProducto=" + cantidadStockProducto + ", precioCompraProducto=" + precioCompraProducto
				+ ", precioVentaProducto=" + precioVentaProducto + ", descuentoProducto=" + descuentoProducto
				+ ", monedaProducto=" + monedaProducto + ", fechaAltaProducto=" + fechaAltaProducto
				+ ", fechaModificacionProducto=" + fechaModificacionProducto + ", estadoActivoProducto="
				+ estadoActivoProducto + ", clientes=" + clientes + "]";
	}

}
