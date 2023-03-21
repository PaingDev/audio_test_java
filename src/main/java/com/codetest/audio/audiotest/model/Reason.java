package com.codetest.audio.audiotest.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reason")
public class Reason {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(columnDefinition = "serial")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "machine")
	private Machine machine;

	private String reason;

	@OneToMany(targetEntity = Anomaly.class, mappedBy = "reason")
	private Set<Anomaly> anomalys = new HashSet<Anomaly>();

	public Reason(Long id, Machine machine, String reason) {
		super();
		this.id = id;
		this.machine = machine;
		this.reason = reason;
	}

	public Reason(Long reasonId) {
		this.id = reasonId;
	}
	
	

}
