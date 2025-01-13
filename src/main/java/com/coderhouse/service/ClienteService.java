package com.coderhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes(){
		
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
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
	
	public void deleteClienteById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		clienteRepository.deleteById(id);
		
	}
	
	
	
}
