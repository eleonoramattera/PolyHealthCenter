package PolyHealthCenter.model;

import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "sedi")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 0)
	private String regione;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 1)
	private String comune;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 2)
	private String latitudine ;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 3)
	private String longitudine;
	
	public Sede(String regione, String comune, String latitudine, String longitudine) {
		super();
		this.regione = regione;
		this.comune = comune;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}



}
