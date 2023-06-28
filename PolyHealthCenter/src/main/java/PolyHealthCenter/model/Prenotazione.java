package PolyHealthCenter.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	
	@OneToOne
	private Terapia terapia;

	@ManyToOne
	private Sede sede;
	
	@Column(nullable=false,name="data_prenotazione")
	private LocalDate dataPrenotazione;

	public Prenotazione(Utente utente, Terapia terapia, LocalDate dataPrenotazione) {
		super();
		this.utente = utente;
		this.terapia = terapia;
		this.dataPrenotazione = dataPrenotazione;
	}

	
}