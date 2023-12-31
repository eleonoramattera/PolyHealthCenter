package PolyHealthCenter.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.FeedbackDAORepository;
import PolyHealthCenter.service.FeedbackService;
import PolyHealthCenter.service.UtenteService;

@Component
public class FeedbackRunner implements ApplicationRunner {

	@Autowired FeedbackDAORepository repo;
	@Autowired FeedbackService service;
	@Autowired UtenteService utenteService;
	@Autowired Utente utenteRunner;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("feedback runner...");
		
//		Feedback f1 = service.createFakeFeedback();
//		
//		 service.createFeedback(f1);
//		
//			Faker fake = new Faker();
//            
//			Feedback f = new Feedback();
//		    f.setTitolo(fake.job().title());
//		    f.setTesto(fake.lorem().words().toString());
//		    f.setRating(fake.number().numberBetween(1, 5));
//		    System.out.println(f);
//			service.createFeedback(f);
			

		
		
			
	}

		
	

}
