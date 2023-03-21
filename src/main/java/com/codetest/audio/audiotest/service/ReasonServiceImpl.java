package com.codetest.audio.audiotest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.model.Reason;
import com.codetest.audio.audiotest.repo.ReasonRepo;

@Service
public class ReasonServiceImpl implements ReasonService{
	
	@Autowired
	ReasonRepo reasonRepo;

	@Override
	public List<Reason> getReasonByMachine(String machine) {
		List<Reason> listReason = new ArrayList<Reason>();
		if(machine == null) {
			listReason = reasonRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
		}else {
			
			listReason = reasonRepo.findByMachine(new Machine(machine), Sort.by(Sort.Direction.ASC, "id"));
		}
		
		return listReason;
	}

	
}
