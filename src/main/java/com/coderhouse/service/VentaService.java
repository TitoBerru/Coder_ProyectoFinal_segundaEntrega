package com.coderhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Venta;
import com.coderhouse.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	  // Buscar todas las ventas
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }
    
    //Buscar Venta por Id
    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }
    
    
	 // Crear venta
    @Transactional
    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
    
 // Updatear venta
    @Transactional
    public Venta actualizarVenta(Long id, Venta ventaActualizada) {
    	Venta ventaEncontrada = ventaRepository.findById(id)
    			.orElseThrow(() -> new IllegalArgumentException("Venta no encontrado"));
    	
    	ventaEncontrada.setNumeroFactura(ventaActualizada.getNumeroFactura());
    	ventaEncontrada.setFechaVenta(ventaActualizada.getFechaVenta());
    	ventaEncontrada.setTotalVenta(ventaActualizada.getTotalVenta());
    	ventaEncontrada.setCliente(ventaActualizada.getCliente());
    	ventaEncontrada.setDetalles(ventaActualizada.getDetalles());
    
            return ventaRepository.save(ventaEncontrada);
    
    }
    
    // Eliminar venta
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
    
}
