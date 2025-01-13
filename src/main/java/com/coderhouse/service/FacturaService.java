package com.coderhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Factura;
import com.coderhouse.repositories.FacturaRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;
	
	  // Buscar todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }
    
    //Buscar Factura por Id
    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id);
    }
    
    
	 // Crear Factura
    @Transactional
    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
    
 // Updatear Factura
    @Transactional
    public Factura actualizarFactura(Long id, Factura facturaActualizada) {
    	Factura facturaEncontrada = facturaRepository.findById(id)
    			.orElseThrow(() -> new IllegalArgumentException("factura no encontrado"));
    	
    	facturaEncontrada.setNumeroFactura(facturaActualizada.getNumeroFactura());
    	facturaEncontrada.setFechaVenta(facturaActualizada.getFechaVenta());
    
            return facturaRepository.save(facturaEncontrada);
    
    }
    
    // Eliminar factura
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
    
}
