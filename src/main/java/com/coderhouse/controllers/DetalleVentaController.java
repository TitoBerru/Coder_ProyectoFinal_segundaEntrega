package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.DetalleVenta;
import com.coderhouse.service.DetalleVentaService;

@RestController
@RequestMapping("/api/v1/detalleVentas")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaService detalleVentaService;

	// Obtener todos los detalles de venta
	@GetMapping
	public List<DetalleVenta> obtenerTodosLosDetallesDeVenta() {
		return detalleVentaService.obtenerTodosLosDetallesDeVenta();
	}

	// Obtener detalle de venta por ID
	@GetMapping("/{id}")
	public ResponseEntity<DetalleVenta> obtenerDetalleVentaPorId(@PathVariable Long id) {
		return detalleVentaService.obtenerDetalleVentaPorId(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


}
