package com.coderhouse.dtos;

import java.util.List;

public class VentaDetalleDTO {
		
	private Long clienteId;
	private List<Long> productoIds;
	
	// Getter an Setter
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public List<Long> getProductoIds() {
		return productoIds;
	}
	public void setProductoIds(List<Long> productoIds) {
		this.productoIds = productoIds;
	}
	
	
	
	
	
	
}
