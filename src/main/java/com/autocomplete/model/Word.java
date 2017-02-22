package com.autocomplete.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by arvindkasale on 2/22/17.
 */
@Entity
@Table(name = "words")
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String state;
	private String city;
	private String country;
	private int count;
	@OneToOne
	private Alphabet alphabet;

	public Word() {

	}

	public Word(String name) {
		this.name = name;
		this.address1 = name + " address1";
		this.address2 = name + " address2";
		this.address3 = name + " address3";
		this.address4 = name + " address4";
		this.state = name + " state";
		this.city = name + " city";
		this.country = name + "country";
		this.count = 3;
	}

	public Alphabet getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(Alphabet alphabet) {
		this.alphabet = alphabet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
