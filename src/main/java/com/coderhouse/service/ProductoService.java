package com.coderhouse.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {
		@Autowired
		private ProductoRepository productoRepository;
		
		public List<Producto> getAllProductos(){
			return productoRepository.findAll();
		}
		
		public Producto findById(Long id) {
			return productoRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		}
		
		@Transactional
		public Producto saveProducto(Producto producto) {
			return productoRepository.save(producto);
		}
		
		@Transactional
		public Producto updateProductoById(Long id, Producto productoDetails) {
		    // Buscar el producto existente por ID
		    Producto productoEncontrado = productoRepository.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		    
		    // Actualizar los campos permitidos si los valores no son nulos o válidos
		    if (productoDetails.getNombreProducto() != null && !productoDetails.getNombreProducto().isEmpty()) {
		        productoEncontrado.setNombreProducto(productoDetails.getNombreProducto());
		    }

		    if (productoDetails.getDescripcionProducto() != null && !productoDetails.getDescripcionProducto().isEmpty()) {
		        productoEncontrado.setDescripcionProducto(productoDetails.getDescripcionProducto());
		    }

		    if (productoDetails.getCategoriaProducto() != null && !productoDetails.getCategoriaProducto().isEmpty()) {
		        productoEncontrado.setCategoriaProducto(productoDetails.getCategoriaProducto());
		    }

		    if (productoDetails.getMarcaProducto() != null && !productoDetails.getMarcaProducto().isEmpty()) {
		        productoEncontrado.setMarcaProducto(productoDetails.getMarcaProducto());
		    }

		    if (productoDetails.getProveedorProducto() != null && !productoDetails.getProveedorProducto().isEmpty()) {
		        productoEncontrado.setProveedorProducto(productoDetails.getProveedorProducto());
		    }

		    if (productoDetails.getImgUrlProducto() != null && !productoDetails.getImgUrlProducto().isEmpty()) {
		        productoEncontrado.setImgUrlProducto(productoDetails.getImgUrlProducto());
		    }
		    	// No pueden ser menor a 0.
		    if (productoDetails.getCantidadStockProducto() >= 0) {
		        productoEncontrado.setCantidadStockProducto(productoDetails.getCantidadStockProducto());
		    }

		    if (productoDetails.getPrecioCompraProducto() >= 0) {
		        productoEncontrado.setPrecioCompraProducto(productoDetails.getPrecioCompraProducto());
		    }

		    if (productoDetails.getPrecioVentaProducto() >= 0) {
		        productoEncontrado.setPrecioVentaProducto(productoDetails.getPrecioVentaProducto());
		    }

		    if (productoDetails.getDescuentoProducto() >= 0) {
		        productoEncontrado.setDescuentoProducto(productoDetails.getDescuentoProducto());
		    }
		    
		    if (productoDetails.getMonedaProducto() != null && !productoDetails.getMonedaProducto().isEmpty()) {
		        productoEncontrado.setMonedaProducto(productoDetails.getMonedaProducto());
		    }

		    // Set y get de FechaModificacionProducto, no seria neceario ya que lo hago desde el modelo
		    // al usar localDate
		    return productoRepository.save(productoEncontrado);
		}

			
		
		
		public void deleteProductoById(Long id) {
			if(!productoRepository.existsById(id)) {
				throw new IllegalArgumentException("Producto no encontrado");
			}
			productoRepository.deleteById(id);
			
		}
}
