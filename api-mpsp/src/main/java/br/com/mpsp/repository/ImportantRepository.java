package br.com.mpsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.mpsp.model.ImportantModel;




@Repository
public interface ImportantRepository extends JpaRepository<ImportantModel, Integer>{
	
}
