package com.example.demopgsql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "phones")
@EntityListeners(AuditingEntityListener.class)
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; // Each phone will be given an auto-generated unique identifier when stored

	@Column(name = "phone_name", nullable = false)
	private String phoneName; // Save the name of the phone

	@Column(name = "os", nullable = false)
	private String os; // Save the operating system running in the phone

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

}
