package PolyHealthCenter.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Terapia;
import PolyHealthCenter.repository.TerapiaDAORepository;
import PolyHealthCenter.service.TerapiaService;

@Component
public class TerapiaRunner implements ApplicationRunner{
	
	@Autowired TerapiaDAORepository repo;
	@Autowired TerapiaService service;
	@Override
	public void run(ApplicationArguments args) throws Exception {

	//	System.out.println("terapia runner...");
		
//			Faker fake = new Faker();
//
//			Terapia t = new Terapia();
//		    t.setNome(fake.name().firstName());
//			t.setDescrizione(fake.lorem().paragraph());
//		    t.setPrezzo(fake.number().randomDouble(02,20,99));
//			System.out.println(t);
//			service.createTerapia(t);
			

		
		
	}

}
