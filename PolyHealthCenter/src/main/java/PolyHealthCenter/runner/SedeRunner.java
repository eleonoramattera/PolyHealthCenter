package PolyHealthCenter.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		System.out.println("sedi runner..");
      
		if (repo.findAll().isEmpty()) {

		//	setSedi();
	//		esempio();
	
	}
	}
	
	public void setSedi() throws IOException, CsvValidationException {

		try (CSVReader reader = new CSVReader(new FileReader(
				"C:\\Users\\Micro\\Desktop\\csvjsonfinale.csv"))) {
			String[] lineInArray;
			while ((lineInArray = reader.readNext()) != null) {
				String[] parts = lineInArray[0].split(";");
			    String part1 = parts[0];
				String part2 = parts[1];
				String part3= parts[2];
				String part4 = parts[3];
				
			

				Sede s = new Sede(part1, part2, part3, part4);
				repo.save(s);
			}
		}
	}

//	
	
//
//	    public void esempio () throws CsvValidationException {
//	        String csvFile = "C:\\Users\\Micro\\Desktop\\csvjsonfinale.csv"; // Sostituisci con il percorso del tuo file CSV
//	        List<Sede> sedi = new ArrayList<>();
//
//
//	        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
//	            String[] header = reader.readNext(); // Leggi la riga dell'intestazione (header)
//	            String[] line;
//	            while ((line = reader.readNext()) != null) {
//	                Sede s = new Sede();
//	                s.setLat(Long.parseLong(line[0]));
//	                s.setLon(Long.parseLong(line[1]));
//	                s.setComune(line[2]);
//	                s.setRegione(line[3]);
//	                sedi.add(s);
//
//	               
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//
//	     
//	    }
//	      

	      

	    
	


	 

	
	
}