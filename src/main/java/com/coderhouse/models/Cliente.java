package com.coderhouse.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para volverlo autoincremental
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 100)
	private String apellido;

	@Column(nullable = false, unique = true)
	private int dni;

	@Column(unique = true, length = 100)
	private String email;

	@Column(length = 150)
	private String direccion;

	@Column(length = 100)
	private String localidad;

	@Column(length = 100)
	private String provincia;

	private Date fechaNac;

	private Date fechaRegistro;

	private Date fechaModificacionRegistro;

	private boolean estadoActivo;

	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();

	private LocalDateTime createdAt;

	// Constructores
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int dni, boolean estadoActivo, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.estadoActivo = estadoActivo;
		this.productos = productos;
	}

	public Cliente(String nombre, String apellido, int dni) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacionRegistro() {
		return fechaModificacionRegistro;
	}

	public void setFechaModificacionRegistro(Date fechaModificacionRegistro) {
		this.fechaModificacionRegistro = fechaModificacionRegistro;
	}

	public boolean isEstadoActivo() {
		return estadoActivo;
	}

	public void setEstadoActivo(boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email="
				+ email + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", fechaNac=" + fechaNac + ", fechaRegistro=" + fechaRegistro + ", fechaModificacionRegistro="
				+ fechaModificacionRegistro + ", estadoActivo=" + estadoActivo + ", productos=" + productos
				+ ", createdAt=" + createdAt + "]";
	}

}
