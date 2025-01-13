package com.coderhouse.controllers;

import java.util.List;
import java.util.Optional;

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

import com.coderhouse.models.Venta;
import com.coderhouse.service.VentaService;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

	@Autowired
	private VentaService ventaService;

	@GetMapping
	public ResponseEntity<List<Venta>> getAllVentas() {
		try {

			List<Venta> ventas = ventaService.obtenerTodasLasVentas();
			return ResponseEntity.ok(ventas); // 200
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Venta>> getVentaByID(@PathVariable Long id) {
		try {
			Optional<Venta> venta = ventaService.obtenerVentaPorId(id);
			return ResponseEntity.ok(venta); // 200
		}

		catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
		try {
			Venta ventaCreada = ventaService.crearVenta(venta);
			return ResponseEntity.status(HttpStatus.CREATED).body(ventaCreada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Venta> editVentaById(@PathVariable Long id, @RequestBody Venta ventaModificada) {
		try {
			Venta ventaAModificar = ventaService.actualizarVenta(id, ventaModificada);
			return ResponseEntity.ok(ventaAModificar);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVentaById(@PathVariable Long id) {
		try {
			ventaService.eliminarVenta(id);
			return ResponseEntity.noContent().build(); // 400
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
}
