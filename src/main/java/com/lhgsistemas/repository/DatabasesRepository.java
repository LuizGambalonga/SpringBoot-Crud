package com.lhgsistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lhgsistemas.model.DatabaseModel;

@Repository
public interface DatabasesRepository extends JpaRepository  <DatabaseModel, Long>{

}