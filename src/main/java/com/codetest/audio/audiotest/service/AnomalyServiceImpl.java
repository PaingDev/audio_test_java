package com.codetest.audio.audiotest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.audio.audiotest.dto.AnomalyUpdateDto;
import com.codetest.audio.audiotest.model.Action;
import com.codetest.audio.audiotest.model.Anomaly;
import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.model.Reason;
import com.codetest.audio.audiotest.repo.ActionRepo;
import com.codetest.audio.audiotest.repo.AnomalyRepo;
import com.codetest.audio.audiotest.repo.ReasonRepo;

@Service
public class AnomalyServiceImpl implements AnomalyService{
	
	@Autowired
	AnomalyRepo anomalyRepo;
	
	@Autowired
	ActionRepo actionRepo;
	
	@Autowired
	ReasonRepo reasonRepo;

	@Override
	public List<Anomaly> getAllAnomaly() {
		return anomalyRepo.findAll();
	}

	@Override
	public List<Anomaly> getAnomalyByMachine(String machine) {
		List<Anomaly> listAnomaly;
		if(machine == null) {
			listAnomaly = anomalyRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
		}else {
			listAnomaly = anomalyRepo.findByMachine(new Machine(machine), Sort.by(Sort.Direction.ASC, "id"));
		}
		
		return listAnomaly;
	}

	@Transactional(readOnly = false)
	@Override
	public void updateAnomaly(AnomalyUpdateDto anomalyPostDto) {
		Optional<Anomaly> optAnomaly = anomalyRepo.findById(anomalyPostDto.getId());
		if(optAnomaly.isPresent()) {
			Anomaly anomaly = optAnomaly.get();
			
			anomaly.setAction(actionRepo.findById(anomalyPostDto.getActionId()).get());
			anomaly.setReason(reasonRepo.findById(anomalyPostDto.getReasonId()).get());
			anomaly.setComment(anomalyPostDto.getComment());
		}
	}

	
}
