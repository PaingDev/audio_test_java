package com.codetest.audio.audiotest.service;

import java.util.List;

import com.codetest.audio.audiotest.dto.AnomalyUpdateDto;
import com.codetest.audio.audiotest.model.Anomaly;

public interface AnomalyService {

	List<Anomaly> getAllAnomaly();

	List<Anomaly> getAnomalyByMachine(String machine);

	void updateAnomaly(AnomalyUpdateDto anomalyPostDto);

}
