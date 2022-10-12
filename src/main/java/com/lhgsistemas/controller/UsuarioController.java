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

import com.lhgsistemas.model.UsuarioModel;
import com.lhgsistemas.services.UsuarioService;


@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping()
	public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuarioModel) {
		usuarioModel.setAud_dh_criacao(LocalDateTime.now());
		UsuarioModel database = usuarioService.salvarUsuario(usuarioModel);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(database);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable Long id,@RequestBody UsuarioModel usuarioModel) {
		
		UsuarioModel databaseAtual = usuarioService.atualizarUsuario(id, usuarioModel);
		
		if( databaseAtual !=null) {
			return new ResponseEntity<>(databaseAtual,HttpStatus.OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado o ID da Usuario na base de dados");
		}
		
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UsuarioModel>> buscarPorId(@PathVariable Long id) {
		Optional<UsuarioModel> database = usuarioService.buscarPorId(id);
		
		if(database !=null){
			return ResponseEntity.ok(database);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	public ResponseEntity <List<UsuarioModel>> buscarTodosUsuarios() {	
		List<UsuarioModel> usuariosLocalizados = usuarioService.listAll();
		
		if(usuariosLocalizados !=null) {
			return ResponseEntity.ok(usuariosLocalizados);	
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <UsuarioModel> excluirUsuario(@PathVariable Long id) {	
		
		usuarioService.excluirUsuario(id);
		
		return ResponseEntity.noContent().build();
	}
    

}
