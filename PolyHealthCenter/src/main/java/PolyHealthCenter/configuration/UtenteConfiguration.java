package PolyHealthCenter.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.service.FeedbackService;
import PolyHealthCenter.service.PrenotazioneService;

@Component
public class UtenteConfiguration {
	
	@Autowired PrenotazioneService prenotazioneService;
	@Autowired FeedbackService feedbackService;
	
	@Bean("FakeUtenteBean")
	@Scope("prototype")
	public Utente fakeUtente() {
		
	Faker fake = Faker.instance(new Locale("it-IT"));
	
//	List<Prenotazione> prenotazioni = new ArrayList<>();
//	prenotazioni.add(prenotazioneService.getPrenotazioneRandom());
//	
	List<Feedback> feedback = new ArrayList<>();
	feedback.add(feedbackService.getFeedbackRandom());
	
	Utente utenteFake = new Utente();
	utenteFake.setNome(fake.name().firstName());
	utenteFake.setCognome(fake.name().lastName());
	utenteFake.setEmail(	utenteFake.getNome() + "." + 	utenteFake.getCognome() + "@example.com");
	utenteFake.setNumeroTelefono(fake.phoneNumber().cellPhone());
	utenteFake.setPassword(fake.letterify("00????00"));	
//	utenteFake.setPrenotazioni(prenotazioni);
	utenteFake.setFeedback(feedback);
	return utenteFake;
	}

}
