package PolyHealthCenter.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.FeedbackDAORepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FeedbackService {
	
	@Autowired FeedbackDAORepository repo;
	@Autowired @Qualifier("FakeFeedbackBean") ObjectProvider<Feedback> feedbackFakeProvider;

	public Feedback createFakeFeedback() {
		return repo.save(feedbackFakeProvider.getObject());
	}
	
	public Feedback getFeedbackRandom() {
		return repo.findByFeedbackRandom();
	}
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
	  if(repo.existsByUtente(feedback.getUtente()) ) {
		throw new EntityNotFoundException(" feedback di " + feedback.getUtente() + " con id "  +  "già presente");
		  }
	  System.out.println("Feedback con id " + feedback.getId() +" inserito nel DB");
	  return repo.save(feedback);
	}

	
	
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
	


}
