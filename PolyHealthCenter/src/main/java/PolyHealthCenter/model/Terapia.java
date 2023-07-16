package PolyHealthCenter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "terapie")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Terapia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private Double prezzo;

	
//	@JsonIgnore
//	@OneToMany (mappedBy = "terapia")
//     private List<Feedback> feedback;
}
