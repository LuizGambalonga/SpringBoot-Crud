package com.lhgsistemas.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lhgsistemas.model.UsuarioModel;
import com.lhgsistemas.repository.UsuarioRepository;


@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping()
	public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuarioModel) {
		usuarioModel.setAud_dh_criacao(LocalDateTime.now());
		UsuarioModel persistir = this.usuarioRepository.save(usuarioModel);
        return new ResponseEntity<>(persistir, HttpStatus.OK);
    }
    

}
