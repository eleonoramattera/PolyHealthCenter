package PolyHealthCenter.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.service.UtenteService;


@Component
public class FeedbackConfiguration {
	
    @Autowired UtenteService utenteService;
	
	@Bean("FakeFeedbackBean")
	@Scope("prototype")
	public Feedback fakeFeedback() {
	Faker fake = Faker.instance(new Locale("it-IT"));
	Feedback feedbackFake = new Feedback();
	feedbackFake.setTitolo(fake.job().title());
	feedbackFake.setTesto(fake.lorem().words().toString());
	feedbackFake.setRating(fake.number().numberBetween(1, 5));
    feedbackFake.setUtente(utenteService.getUtenteRandom());
    
	return feedbackFake;
	}
	
}
