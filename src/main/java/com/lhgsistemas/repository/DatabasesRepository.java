package com.lhgsistemas.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lhgsistemas.model.DatabaseModel;

@Repository
public interface DatabasesRepository extends JpaRepository  <DatabaseModel, Long>{

	Optional<DatabaseModel> save(Optional<DatabaseModel> databaseAtual);

}