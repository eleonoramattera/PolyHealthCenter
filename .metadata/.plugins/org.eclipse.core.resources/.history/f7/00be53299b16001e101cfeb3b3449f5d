package PolyHealthCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Feedback;

@Repository
public interface FeedbackDAORepository  extends JpaRepository<Feedback, Long>{

	public boolean existsByEmail(String email);
	public Feedback findByEmail(String email);
}
