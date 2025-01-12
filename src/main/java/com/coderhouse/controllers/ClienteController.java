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
import com.coderhouse.models.Cliente;
import com.coderhouse.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

		@Autowired
		private ClienteService clienteService;
		
		@GetMapping
		public ResponseEntity<List<Cliente>> getAllClientes(){
			try {
			
				List<Cliente> clientes = clienteService.getAllClientes();
				return ResponseEntity.ok(clientes); //200
			}
			catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> getClienteByID(@PathVariable Long id){
			try {
				Cliente cliente = clienteService.findById(id);
				return ResponseEntity.ok(cliente); // 200
			}
		
			catch(IllegalArgumentException e) {
				return ResponseEntity.notFound().build();  //404
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
			}
		}
		@PostMapping("/create")
		public ResponseEntity<Cliente> createAlumno(@RequestBody Cliente cliente) {
			try {
				Cliente clienteCreado = clienteService.saveCliente(cliente);
				return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
			}
			catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
			}	
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Cliente> editClienteById(@PathVariable Long id, @RequestBody Cliente clienteModificado){
			try {
				Cliente clienteAModificar = clienteService.updateClienteById(id, clienteModificado);
				return ResponseEntity.ok(clienteAModificar);
			}
		catch(IllegalArgumentException e) {
				return ResponseEntity.notFound().build();  //404
			}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteClienteById(@PathVariable Long id){
			try {
				clienteService.deleteClienteById(id);
				return ResponseEntity.noContent().build(); //400
			}
			catch(IllegalArgumentException e) {
				return ResponseEntity.notFound().build();  //404
			}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
			}
		}
			
}
