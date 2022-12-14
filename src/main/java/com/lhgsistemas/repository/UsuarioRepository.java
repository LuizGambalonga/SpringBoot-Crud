package com.lhgsistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhgsistemas.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository  <UsuarioModel, Long>{

}