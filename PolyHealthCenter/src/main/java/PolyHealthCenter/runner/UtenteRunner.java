package PolyHealthCenter.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.UtenteDAORepository;
import PolyHealthCenter.service.UtenteService;

@Component
public class UtenteRunner implements ApplicationRunner{
	@Autowired UtenteDAORepository repo;

	@Autowired UtenteService service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("utenti runner...");
		if (repo.findAll().isEmpty()) {
			Faker fake = new Faker();

			Utente u = new Utente();
		    u.setNome(fake.name().firstName());
			u.setCognome(fake.name().lastName());
			u.setEmail(fake.internet().emailAddress());
			u.setNumeroTelefono(fake.phoneNumber().cellPhone());
			u.setPassword(fake.letterify("00????00"));
			System.out.println(u);
				service.createUtente(u);
			

		}
	}

}
