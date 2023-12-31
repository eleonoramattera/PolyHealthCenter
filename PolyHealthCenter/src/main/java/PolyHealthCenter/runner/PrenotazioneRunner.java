package PolyHealthCenter.runner;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import PolyHealthCenter.service.UtenteService;
import PolyHealthCenter.service.SedeService;
import PolyHealthCenter.service.TerapiaService;
import PolyHealthCenter.service.PrenotazioneService;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.SedeDAORepository;
import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Sede;
import PolyHealthCenter.model.Terapia;

@Component
public class PrenotazioneRunner  implements ApplicationRunner {


	@Autowired UtenteService utenteservice;
	@Autowired SedeService sedeservice;
	@Autowired TerapiaService terapiaservice;
	@Autowired PrenotazioneService prenotazioneservice;
	@Autowired SedeDAORepository repo;
	
	public static Scanner scan = new Scanner(System.in);
	
	Utente utente = null;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		setSedi();
//		utenteservice.createFakeUtente();
//		terapiaservice.createFakeTerapia();
//	
//		
//		System.out.println("*** START***");
//		System.out.println("Benvenuto nel sistema GestionePrenotazioni!");
//		System.out.print("Scegli il tuo id Utente:");
//		Long uid = scan.nextLong();
//		try {
//			utente = utenteservice.getById(uid);
//		} catch (Exception e) {
//			System.out.print("L'utente selezionato non esiste");
//			System.exit(1);
//		}
//		while (true) {
//			menuPrincipale();
//		}
//		
	}
	
//	public void menuPrincipale() {
//		System.out.println("Ciao " + utente.getNome() + utente.getCognome() + "! Cosa vuoi fare?");
//		System.out.println("1 - ELENCO PRENOTAZIONI A TUO NOME");
////		System.out.println("2 - CERCA TERAPIA PER REGIONE");
////		System.out.println("3 - CERCA POSTAZIONE PER TIPOLOGIA");
//		System.out.println("2 - INSERISCI NUOVA PRENOTAZIONE");
//		System.out.println("0 - ESCI DALL'APPLICAZIONE");
//		int scelta = scan.nextInt();
//		switch (scelta) {
//		case 1:
//			List<Prenotazione> prenota = prenotazioneservice.getByUtente(utente);
//			if (prenota.size() > 0) {				
//				prenota.forEach(el -> System.out.println(el));
//			} else {
//				System.out.println("Non esistono prenotazioni a tuo nome!!");
//			}
//			break;
//		case 2:
//			System.out.print("Inserisci l'ID della terapia da prenotare");
//			Long terapiaid = scan.nextLong();
//			Terapia terapia = null;
//			System.out.print("Inserisci l'ID della sede1");
//			Long sedeid = scan.nextLong();
//			Sede sede = null;
//			try {
//				terapia = terapiaservice.getById(terapiaid);
//				sede = sedeservice.getById(sedeid);
//			} catch (Exception e) {
//				System.out.println("Terapia/Sede inesistente!!!");
//				break;
//			}
//			System.out.print("Inserisci la data della prenotazione");
//			LocalDate data = genData();
//			System.out.println("Data inserita!!!");
//			prenotazioneservice.salvaPrenotazione(new Prenotazione(utente, terapia, data, sede));
//			scan.nextLine();
//			break;
//		case 0:
//			System.out.print("Richiesta Chiusura dall'utente!");
//			System.exit(0);
//			break;
//		default:
//			System.out.print("Scelta non valida!!!");
//			break;
//		}
//		
//	}
//
//	public static LocalDate genData() {
//		System.out.print("Inserisci Giorno (DD):");
//		int giorno = scan.nextInt();
//		System.out.print("Inserisci Mese (MM):");
//		int mese = scan.nextInt();
//		System.out.print("Inserisci Anno (YYYY):");
//		int anno = scan.nextInt();
//		return LocalDate.of(anno, mese, giorno);
//	}
//	
//	
//	
//	public void setSedi() throws IOException, CsvValidationException {
//
//		try (CSVReader reader = new CSVReader(new FileReader(
//				"C:\\Users\\Micro\\Desktop\\sedi.csv"))) {
//			String[] lineInArray;
//			while ((lineInArray = reader.readNext()) != null) {
//				String[] parts = lineInArray[0].split(";");
//				String part1 = parts[0];
//				String part2 = parts[1];
//			
//
//				Sede s = new Sede(part1, part2);
//				repo.save(s);
//			}
//		}
//	}
}
