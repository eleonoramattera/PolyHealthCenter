package PolyHealthCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Terapia;

@Repository
public interface TerapiaDAORepository extends JpaRepository<Terapia, Long>{
 
	public boolean existsByNome(String name);
	
	@Query(value="SELECT t FROM Terapia t ORDER BY RANDOM() LIMIT 1")
	Terapia findByTerapiaRandom();
	
}
