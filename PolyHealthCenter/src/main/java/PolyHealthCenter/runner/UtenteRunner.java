package PolyHealthCenter.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.UtenteDAORepository;
import PolyHealthCenter.service.FeedbackService;
import PolyHealthCenter.service.PrenotazioneService;
import PolyHealthCenter.service.UtenteService;

@Component
public class UtenteRunner implements ApplicationRunner{

	@Autowired UtenteDAORepository repo;
	@Autowired UtenteService service;
	@Autowired PrenotazioneService prenotazioneService;
	@Autowired FeedbackService feedbackService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("utenti runner...");
		
//		Utente u1 = service.createFakeUtente();
//	    service.createUtente(u1);
		
//			Faker fake = new Faker();
//			List<Prenotazione> prenotazioni = new ArrayList<>();
//			prenotazioni.add(prenotazioneService.getPrenotazioneRandom());
//			
//			List<Feedback> feedback = new ArrayList<>();
//			feedback.add(feedbackService.getFeedbackRandom());
//			
//			Utente u = new Utente();
//		    u.setNome(fake.name().firstName());
//			u.setCognome(fake.name().lastName());
//			u.setEmail(fake.internet().emailAddress());
//			u.setNumeroTelefono(fake.phoneNumber().cellPhone());
//			u.setPassword(fake.letterify("00????00"));
//			System.out.println(u);
//			service.createUtente(u);
		
		
			

		
	}

}
