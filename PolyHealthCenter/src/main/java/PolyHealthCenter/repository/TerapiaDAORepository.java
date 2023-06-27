package PolyHealthCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Terapia;

@Repository
public interface TerapiaDAORepository extends JpaRepository<Terapia, Long>{

	
}
