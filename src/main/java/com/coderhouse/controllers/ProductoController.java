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

import com.coderhouse.models.Producto;
import com.coderhouse.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	//Obtener todos los productos
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProductos() {
		try {

			List<Producto> productos = productoService.getAllProductos();
			return ResponseEntity.ok(productos); // 200
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	
	//Obtener 1 producto by Id
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoByID(@PathVariable Long id) {
		try {
			Producto producto = productoService.findById(id);
			return ResponseEntity.ok(producto); // 200
		}

		catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	
	// Crear 1 producto
	@PostMapping("/create")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		try {
			Producto productoCreado = productoService.saveProducto(producto);
			return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	// Editar  producto
	@PutMapping("/{id}")
	public ResponseEntity<Producto> editProductoById(@PathVariable Long id, @RequestBody Producto productoModificado) {
		try {
			Producto productoAModificar = productoService.updateProductoById(id, productoModificado);
			return ResponseEntity.ok(productoAModificar);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	
	//Borrar Producto
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductoById(@PathVariable Long id) {
		try {
			productoService.deleteProductoById(id);
			return ResponseEntity.noContent().build(); // 400
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
}
