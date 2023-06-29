package PolyHealthCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.FeedbackDAORepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FeedbackService {
	
	@Autowired FeedbackDAORepository repo;
	
	//CRUD METHODS
	
	// getAll
	public List<Feedback> getAll() {
	  return  repo.findAll();
	   }
		
	//getByID
	public Feedback getById(Long id) {
	 if (!repo.existsById(id)) {
	   throw new EntityNotFoundException("Feedback con id " + id + " non esiste!");
	   }
	   return repo.findById(id).get();
    }
		
	//create
	public Feedback createFeedback(Feedback feedback) {
    // Gestione di un errore | email già presente
	  if(repo.existsById(feedback.getId()) || repo.existsByEmail(feedback.getEmail())) {
		throw new EntityNotFoundException(" feedback già presente");
		  }
	  return repo.save(feedback);
	}
	
//	public Testimonianza getTestimonianzaRandom() {
//		return repo.findByTestimonianzaRandom();
//	}
	
	//update
	public Feedback updateFeedback(Feedback feedback, Long id) {
	  if (repo.existsById(id)) {
		throw new EntityExistsException(" Feedback [id:" + feedback.getId() + "] non esiste");
			}
		repo.save(feedback);
		return feedback;
		}
		
		
	//remove
	public String removeFeedback(Long id) {
	   if (!repo.existsById(id)) {
		 throw new EntityExistsException("Feedback con id " + id + " non è presente nel DB");
	   }
		repo.deleteById(id);
		return "Feedback cancellato!";
		}
	
	//CUSTOM METHODS

	public Feedback getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	

}
