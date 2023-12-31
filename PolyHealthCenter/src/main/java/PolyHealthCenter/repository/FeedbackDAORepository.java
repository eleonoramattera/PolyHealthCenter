package PolyHealthCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;

@Repository
public interface FeedbackDAORepository  extends JpaRepository<Feedback, Long>{

	public boolean existsByUtente(Utente utente);
	Feedback findByUtente(Utente utente);
	

	@Query(value="SELECT f FROM Feedback f ORDER BY RANDOM() LIMIT 1")
	Feedback findByFeedbackRandom();
	
	

}
