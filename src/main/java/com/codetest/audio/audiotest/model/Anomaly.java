package com.codetest.audio.audiotest.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anomaly")
public class Anomaly {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
	private Date timeStamp;
	
	@ManyToOne()
	@JoinColumn(name = "machine")
	private Machine machine;
	private String anomaly;
	private String sensor;
	private String soundClip;
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "reason_id")
	private Reason reason;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "action_id")
	private Action action;
	
	public Anomaly(Date timeStamp, Machine machine, String anomaly, String sensor, String soundClip) {
		super();
		this.timeStamp = timeStamp;
		this.machine = machine;
		this.anomaly = anomaly;
		this.sensor = sensor;
		this.soundClip = soundClip;
		this.reason = null;
		this.action = null;
	}
	
	@Transient
	public String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(timeStamp);
	}
	
	
	@Transient
	public String getSoundClipPath() {
		return "/api/v1/audio/"+soundClip;
	}
	
	@Transient
	public String getAnomalySoundClipPath() {
		return "/api/v1/generated/audio/"+soundClip;
	}

	
	
}
