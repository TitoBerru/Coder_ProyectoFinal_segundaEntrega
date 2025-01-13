package com.coderhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderhouse.dtos.VentaDetalleDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Factura;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.FacturaRepository;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	// Obtener todos los clientes
	public List<Cliente> getAllClientes(){
		
		return clienteRepository.findAll();
	}
	//Obtener cliente by id
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	// Crear Cliente
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	// Editar Cliente
	@Transactional
	public Cliente updateClienteById(Long id, Cliente clienteDetails) {
		Cliente clienteEncontrado = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		
		clienteEncontrado.setNombre(clienteDetails.getNombre());
		clienteEncontrado.setApellido(clienteDetails.getApellido());
		clienteEncontrado.setDireccion(clienteDetails.getDireccion());
		clienteEncontrado.setLocalidad(clienteDetails.getLocalidad());
		clienteEncontrado.setProvincia(clienteDetails.getProvincia());
		clienteEncontrado.setFechaNac(clienteDetails.getFechaNac());
		clienteEncontrado.setEstadoActivo(clienteDetails.isEstadoActivo());
		
		
		if (clienteDetails.getDni() !=0 && clienteDetails.getEmail() !=null && !clienteDetails.getEmail().isEmpty() ) {
		
			clienteEncontrado.setEmail(clienteDetails.getEmail());
			clienteEncontrado.setDni(clienteDetails.getDni());
		}
		
		return clienteRepository.save(clienteEncontrado);
		
	}
	// Borrar cliente
	public void deleteClienteById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		clienteRepository.deleteById(id);
		
	}
	
	@Transactional
	public Cliente comprarVariosProductos(VentaDetalleDTO dto) {
		Cliente cliente = clienteRepository.findById(dto.getClienteId())
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		for (Long productoId : dto.getProductoIds()) {
			Producto producto = productoRepository.findById(productoId)
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
			
			cliente.getProductos().add(producto);
			producto.getClientes().add(cliente);
			
			productoRepository.save(producto);
			
		}
		
		return clienteRepository.save(cliente);
		
	}
	
}
