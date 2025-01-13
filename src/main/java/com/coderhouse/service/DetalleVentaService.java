package com.coderhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.DetalleVenta;
import com.coderhouse.repositories.DetalleVentaRepository;

import jakarta.transaction.Transactional;

@Service
public class DetalleVentaService {
		
	 @Autowired
	    private DetalleVentaRepository detalleVentaRepository;
	 

	    // Obtener todos los detalles de venta
	    public List<DetalleVenta> obtenerTodosLosDetallesDeVenta() {
	        return detalleVentaRepository.findAll();
	    }
	    
	    // Obtener detalle de venta por ID
	    public Optional<DetalleVenta> obtenerDetalleVentaPorId(Long id) {
	        return detalleVentaRepository.findById(id);
	    }
	    
	    // Crear detalle de venta
	    @Transactional
	    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) {
	        return detalleVentaRepository.save(detalleVenta);
	    }
	    
	 // Actualizar detalle de venta
	    public DetalleVenta actualizarDetalleVenta(Long id, DetalleVenta detalleVentaActualizado) {
	        return detalleVentaRepository.findById(id).map(detalle -> {
	            detalle.setVenta(detalleVentaActualizado.getVenta());
	            detalle.setProducto(detalleVentaActualizado.getProducto());
	            detalle.setCantidad(detalleVentaActualizado.getCantidad());
	            detalle.setSubtotal(detalleVentaActualizado.getSubtotal());
	            return detalleVentaRepository.save(detalle);
	        }).orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
	    }
	    

	    // Eliminar detalle de venta
	    public void eliminarDetalleVenta(Long id) {
	        detalleVentaRepository.deleteById(id);
	    }
	    
	 
	    
    
	
}
