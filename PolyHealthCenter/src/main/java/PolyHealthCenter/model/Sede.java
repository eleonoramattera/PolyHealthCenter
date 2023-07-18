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
	private String lat;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 1)
	private String lon;

	
	@Column(nullable = false)
	@CsvBindByPosition(position = 2)
	private String regione;
	
	@Column(nullable = false)
	@CsvBindByPosition(position = 3)
	private String comune ;
	
	




	public Sede(String lat, String lon, String regione, String comune) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.regione = regione;
		this.comune = comune;
	}



}
