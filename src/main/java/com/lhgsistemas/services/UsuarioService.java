package com.lhgsistemas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lhgsistemas.exception.EntidadeEmUso;
import com.lhgsistemas.exception.RecursoNaoLocalizado;
import com.lhgsistemas.model.UsuarioModel;
import com.lhgsistemas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioModel salvarUsuario(UsuarioModel database) {
		return usuarioRepository.save(database);
	}
	
	public void excluirUsuario(Long id) {
	 	
	 	try {
	 		usuarioRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Usuario com código %d", id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUso(
				String.format("Usuario de código %d não pode ser removida, pois está em uso", id));
		}
	 	
	}
	
	public  Optional<UsuarioModel> buscarPorId(@PathVariable Long id) {
		
			Optional<UsuarioModel> database = usuarioRepository.findById(id);	
			if (database.isPresent()) {
				return database;
			}
			return null;		
	}
	
	public List<UsuarioModel> listAll() {
		
		List<UsuarioModel> databases = usuarioRepository.findAll();	
		
		if (databases !=null) {
			return databases;
		}else {
			return null;
		}
	}

	public UsuarioModel atualizarUsuario(Long id,UsuarioModel usuarioModel) {
		
		try {
			@SuppressWarnings("deprecation")
			UsuarioModel databaseAtual = usuarioRepository.getById(id);
			
			if(databaseAtual !=null) {
				databaseAtual.setAud_dh_alteracao(LocalDateTime.now());
				BeanUtils.copyProperties(usuarioModel, databaseAtual, "i_databases","aud_dh_criacao");
				databaseAtual = usuarioRepository.save(databaseAtual);
				
				return databaseAtual;
			}

			return null;
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Usuario com código %d", id));
		} 
	
	}
}
