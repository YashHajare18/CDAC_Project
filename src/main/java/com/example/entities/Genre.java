package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private int genreid;

	@Column(name = "genre_desc")
	private String genredesc;

//	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
//	@JoinColumn(name = "language_id")
//	private Language languageId;

	

	public String getGenredesc() {
		return genredesc;
	}

	public int getGenreid() {
		return genreid;
	}

	public void setGenreid(int genreid) {
		this.genreid = genreid;
	}

	public void setGenredesc(String genredesc) {
		this.genredesc = genredesc;
	}

	

//	public Language getLanguageId() {
//		return languageId;
//	}
//
//	public void setLanguageId(Language languageId) {
//		this.languageId = languageId;
//	}
	
	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", genredesc=" + genredesc + "]";
	}
	

}
