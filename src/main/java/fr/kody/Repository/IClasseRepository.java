package fr.kody.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.kody.Entity.Classe;

@Repository
public interface IClasseRepository extends JpaRepository<Classe, Long> {
	
	List<Classe> findByLibelle(String libelle);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Classe classe where classe.libelle=:libelle")
	void deleteClasse(@Param("libelle")String libelle);

}
