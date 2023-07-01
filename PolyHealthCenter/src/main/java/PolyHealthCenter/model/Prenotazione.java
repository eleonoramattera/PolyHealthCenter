package PolyHealthCenter.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
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
	
	
	@OneToOne
	private Terapia terapia;

	@ManyToOne
	private Sede sede;
	
	@Column(nullable=false,name="data_prenotazione")
	private LocalDate dataPrenotazione;
	
	@ManyToOne
	@JoinTable(name = "prenotazione_utente",
     joinColumns = @JoinColumn(name = "id_prenotazione"),
	  inverseJoinColumns = @JoinColumn(name = "id_utente"))
	private Utente utente;
	
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name = "prenotazione_utente",
//	           joinColumns = @JoinColumn(name = "id_prenotazione"),
//			  inverseJoinColumns = @JoinColumn(name = "id_utente"))
//	private List<Utente> utente;
//	
	public Prenotazione(Utente utente, Terapia terapia, LocalDate dataPrenotazione, Sede sede) {
		super();
		this.utente = utente;
		this.terapia = terapia;
		this.dataPrenotazione = dataPrenotazione;
		this.sede = sede;
	}

	
}
