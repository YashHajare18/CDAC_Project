package com.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int languageId;

	@Column(name = "language_desc")
	private String languageDesc;
   
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "type_id")
//	private ProductType typeId;

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

//	public ProductType getTypeId() {
//		return typeId;
//	}
//
//	public void setTypeId(ProductType typeId) {
//		this.typeId = typeId;
//	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageDesc=" + languageDesc + ", typeId=" +  "]";
	}
}
