package com.codetest.audio.audiotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.audio.audiotest.dto.AnomalyUpdateDto;
import com.codetest.audio.audiotest.model.Anomaly;
import com.codetest.audio.audiotest.service.AnomalyService;

@RestController
@RequestMapping("/api/v1")
public class AnomalyController {
	
	@Autowired
	AnomalyService anomalyService;
	
	@GetMapping("/anomaly")
	List<Anomaly> anomalyByMachine(@RequestParam(required = false, value = "machine") String machine){
		List<Anomaly> listAnomaly = anomalyService.getAnomalyByMachine(machine);
		return listAnomaly;
	}
	
	@PutMapping("/anomaly")
	void updateAnomaly(@RequestBody AnomalyUpdateDto anomalyPostDto){
		anomalyService.updateAnomaly(anomalyPostDto);
		
	}
	
}
