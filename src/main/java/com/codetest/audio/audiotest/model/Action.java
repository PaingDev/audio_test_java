package com.codetest.audio.audiotest.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "action")
public class Action {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(columnDefinition = "serial")
	private Long id;
	private String action;

	
	@OneToMany(targetEntity = Anomaly.class, mappedBy = "action")
	private Set<Anomaly> anomalys = new HashSet<Anomaly>();

	public Action(Long id, String action) {
		super();
		this.id = id;
		this.action = action;
	}

	public Action(Long id) {
		super();
		this.id = id;
	}

	

}
