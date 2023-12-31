package PolyHealthCenter.model;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String titolo;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String testo;
	@Column(nullable = false)
	private Integer rating;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	
	@ManyToOne
	@JoinColumn(name = "id_terapia")
	private Terapia terapia;


	public Feedback(String titolo, String testo, Integer rating, Utente utente, Terapia terapia) {
		super();
		this.titolo = titolo;
		this.testo = testo;
		this.rating = rating;
		this.utente = utente;
		this.terapia = terapia;
	}
	

}
