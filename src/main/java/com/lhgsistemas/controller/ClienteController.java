package com.lhgsistemas.controller;

import java.time.LocalDateTime;
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

import com.lhgsistemas.model.ClienteModel;
import com.lhgsistemas.services.ClienteService;


@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping()
	public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteModel clienteModel) {
		clienteModel.setAud_dh_criacao(LocalDateTime.now());
		ClienteModel cliente = clienteService.salvarCliente(clienteModel);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCliente(@PathVariable Long id,@RequestBody ClienteModel clienteModel) {
		
		ClienteModel clienteAtual = clienteService.atualizarCliente(id, clienteModel);
		
		if( clienteAtual !=null) {
			return new ResponseEntity<>(clienteAtual,HttpStatus.OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado o ID da Cliente na base de dados");
		}
		
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ClienteModel>> buscarPorId(@PathVariable Long id) {
		Optional<ClienteModel> cliente = clienteService.buscarPorId(id);
		
		if(cliente !=null){
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	public ResponseEntity <List<ClienteModel>> buscarTodosClientes() {	
		List<ClienteModel> clientesLocalizados = clienteService.listAll();
		
		if(clientesLocalizados !=null) {
			return ResponseEntity.ok(clientesLocalizados);	
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <ClienteModel> excluirCliente(@PathVariable Long id) {	
		
		clienteService.excluirCliente(id);
		
		return ResponseEntity.noContent().build();
	}
    

}
