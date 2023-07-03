package PolyHealthCenter.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import PolyHealthCenter.model.Sede;

public interface SedeDAORepository extends JpaRepository<Sede, Long>,  PagingAndSortingRepository<Sede, Long>{
   
	public boolean existsByComune(String comune);
	
	Page<Sede> findByComune(String comune, Pageable pageable);
	Page<Sede> findByRegione(String regione, Pageable pageable);
}
