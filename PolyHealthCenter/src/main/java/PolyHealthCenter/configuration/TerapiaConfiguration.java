package PolyHealthCenter.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import PolyHealthCenter.model.Terapia;
import PolyHealthCenter.model.Utente;

@Component
public class TerapiaConfiguration {

	@Bean("FakeTerapiaBean")
	@Scope("prototype")
	public Terapia fakeTerapia() {
		
		Faker fake = Faker.instance(new Locale("it-IT"));
		Terapia terapiaFake = new Terapia();
		terapiaFake.setNome(fake.name().name());
		terapiaFake.setDescrizione(fake.lorem().paragraph());
		terapiaFake.setPrezzo(fake.number().randomDouble(02,20,99));
		return terapiaFake;
	}
	
	
}
