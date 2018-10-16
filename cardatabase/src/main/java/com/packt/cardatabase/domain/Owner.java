package com.packt.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wonerId;
	private String firstName, lastName;

	@Override
	public String toString() {
		return "Owner [wonerId=" + wonerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Owner() {
	}

	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getWonerId() {
		return wonerId;
	}

	public void setWonerId(long wonerId) {
		this.wonerId = wonerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
