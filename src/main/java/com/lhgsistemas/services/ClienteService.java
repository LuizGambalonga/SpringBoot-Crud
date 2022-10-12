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
import com.lhgsistemas.model.ClienteModel;
import com.lhgsistemas.model.DatabaseModel;
import com.lhgsistemas.model.UsuarioModel;
import com.lhgsistemas.repository.ClienteRepository;
import com.lhgsistemas.repository.DatabasesRepository;
import com.lhgsistemas.repository.UsuarioRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DatabasesRepository databaseRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@SuppressWarnings("deprecation")
	public ClienteModel salvarCliente(ClienteModel database) {
	
			Long databaseId = database.getI_databases();
			Long usuarioId = database.getI_usuario();
	
			DatabaseModel dtb = databaseRepository.getById(databaseId);
			UsuarioModel usuario = usuarioRepository.getById(usuarioId);
			
			if (dtb == null) {
				throw new RecursoNaoLocalizado(
					String.format("Não existe cadastro de Database com código %d", databaseId));
			}
			if (usuario == null) {
				throw new RecursoNaoLocalizado(
					String.format("Não existe cadastro de Usuario com código %d", usuarioId));
			}
			database.setI_databases(databaseId);
			database.setI_usuario(usuarioId);
			
		return clienteRepository.save(database);
		
	}
	
	public void excluirCliente(Long id) {
	 	
	 	try {
	 		clienteRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Cliente com código %d", id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUso(
				String.format("Cliente de código %d não pode ser removida, pois está em uso", id));
		}
	 	
	}
	
	public  Optional<ClienteModel> buscarPorId(@PathVariable Long id) {
		
			Optional<ClienteModel> database = clienteRepository.findById(id);	
			if (database.isPresent()) {
				return database;
			}
			return null;		
	}
	
	public List<ClienteModel> listAll() {
		
		List<ClienteModel> clientes = clienteRepository.findAll();	
		
		if (clientes !=null) {
			return clientes;
		}else {
			return null;
		}
	}

	public ClienteModel atualizarCliente(Long id,ClienteModel clienteModel) {
		
		try {
			@SuppressWarnings("deprecation")
			ClienteModel clienteAtual = clienteRepository.getById(id);
			
			if(clienteAtual !=null) {
				clienteAtual.setAud_dh_alteracao(LocalDateTime.now());
				BeanUtils.copyProperties(clienteModel, clienteAtual, "i_clientes","i_usuario","aud_dh_criacao","i_databases");
				clienteAtual = clienteRepository.save(clienteAtual);
				
				return clienteAtual;
			}

			return null;
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoLocalizado(
				String.format("Não existe um cadastro de Cliente com código %d", id));
		} 
	
	}
}
