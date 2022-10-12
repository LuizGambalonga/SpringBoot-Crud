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

import com.lhgsistemas.model.DatabaseModel;

import com.lhgsistemas.services.DatabasesService;


@RestController
@RequestMapping(value = "/databases")
public class DatabasesController {
	
	@Autowired
	private DatabasesService databasesService;
	
	
	@PostMapping()
	public ResponseEntity<DatabaseModel> salvarDatabase(@RequestBody DatabaseModel databaseModel) {
		databaseModel.setAud_dh_criacao(LocalDateTime.now());
		DatabaseModel database = databasesService.salvarDatabase(databaseModel);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(database);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarDatabase(@PathVariable Long id,@RequestBody DatabaseModel databaseModel) {
		
		DatabaseModel databaseAtual = databasesService.atualizarDatabase(id, databaseModel);
		
		if( databaseAtual !=null) {
			return new ResponseEntity<>(databaseAtual,HttpStatus.OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado o ID da Database na base de dados");
		}
		
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<DatabaseModel>> buscarPorId(@PathVariable Long id) {
		Optional<DatabaseModel> database = databasesService.buscarPorId(id);
		
		if(database !=null){
			return ResponseEntity.ok(database);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	public ResponseEntity <List<DatabaseModel>> buscarTodasDatabases() {	
		List<DatabaseModel> databasesLocalizadas = databasesService.listAll();
		
		if(databasesLocalizadas !=null) {
			return ResponseEntity.ok(databasesLocalizadas);	
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <DatabaseModel> excluirDatabase(@PathVariable Long id) {	
		
		databasesService.excluirDatabase(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
