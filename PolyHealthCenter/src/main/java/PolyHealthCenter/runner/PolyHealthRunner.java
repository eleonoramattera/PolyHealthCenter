package PolyHealthCenter.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.service.FeedbackService;
import PolyHealthCenter.service.TerapiaService;
import PolyHealthCenter.service.UtenteService;

@Component
public class PolyHealthRunner implements ApplicationRunner {
	@Autowired UtenteService uservice;

	@Autowired FeedbackService fservice;
	@Autowired TerapiaService tservice;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("RUNNIAMOOOO");
		
		starterDB();
	}
	
	private void starterDB() {

		//utente
		for (int i = 0; i<2; i++) {
			uservice.getUtenteRandom();
			}
		//feedback
		for (int i = 0; i<20; i++) {
		    fservice.getFeedbackRandom();
			}
		//terapia
			for (int i = 0; i<10; i++) {
			tservice.getTerapiaRandom();
				}
		
		
		
		
	}
	

}
