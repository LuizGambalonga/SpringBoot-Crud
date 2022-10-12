package com.lhgsistemas.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
	
	public Optional<DatabaseModel> atualizarDatabase(Long id,DatabaseModel databaseModel) {
		
		try {
			Optional<DatabaseModel> databaseAtual = databasesRepository.findById(id);
			
			if(databaseAtual.isPresent()) {
				databaseModel.setAud_dh_alteracao(LocalDateTime.now());
				
				return databaseAtual;
			}

			return null;
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Database com código %d", id));
		} 
	
	}
	
	
}
