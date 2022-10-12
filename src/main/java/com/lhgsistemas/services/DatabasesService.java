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
import com.lhgsistemas.model.DatabaseModel;
import com.lhgsistemas.repository.DatabasesRepository;


@Service
public class DatabasesService {
	
	@Autowired
	private DatabasesRepository databasesRepository;
	
	public DatabaseModel salvarDatabase(DatabaseModel database) {
		return databasesRepository.save(database);
	}
	
	public void excluirDatabase(Long id) {
	 	
	 	try {
	 		databasesRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Database com código %d", id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUso(
				String.format("Database de código %d não pode ser removida, pois está em uso", id));
		}
	 	
	}
	
	public  Optional<DatabaseModel> buscarPorId(@PathVariable Long id) {
		
			Optional<DatabaseModel> database = databasesRepository.findById(id);	
			if (database.isPresent()) {
				return database;
			}
			return null;		
	}
	
	public List<DatabaseModel> listAll() {
		
		List<DatabaseModel> databases = databasesRepository.findAll();	
		
		if (databases !=null) {
			return databases;
		}else {
			return null;
		}
	}

	public DatabaseModel atualizarDatabase(Long id,DatabaseModel databaseModel) {
		
		try {
			@SuppressWarnings("deprecation")
			DatabaseModel databaseAtual = databasesRepository.getById(id);
			
			if(databaseAtual !=null) {
				databaseAtual.setAud_dh_alteracao(LocalDateTime.now());
				BeanUtils.copyProperties(databaseModel, databaseAtual, "i_databases","aud_dh_criacao");
				databaseAtual = databasesRepository.save(databaseAtual);
				
				return databaseAtual;
			}

			return null;
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Database com código %d", id));
		} 
	
	}
	
	
}
