package PolyHealthCenter.runner;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import PolyHealthCenter.model.Sede;
import PolyHealthCenter.repository.SedeDAORepository;
import com.opencsv.exceptions.CsvValidationException;

@Component
public class SedeRunner implements ApplicationRunner {
	@Autowired SedeDAORepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (repo.findAll().isEmpty()) {

			setSedi();
		
	}
	}
	
	public void setSedi() throws IOException, CsvValidationException {

		try (CSVReader reader = new CSVReader(new FileReader(
				"C:\\Users\\Micro\\Desktop\\sedi.csv"))) {
			String[] lineInArray;
			while ((lineInArray = reader.readNext()) != null) {
				String[] parts = lineInArray[0].split(";");
				String part1 = parts[0];
				String part2 = parts[1];
			

				Sede s = new Sede(part1, part2);
				repo.save(s);
			}
		}
	}

}
