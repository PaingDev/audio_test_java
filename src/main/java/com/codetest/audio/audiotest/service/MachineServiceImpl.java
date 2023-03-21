package com.codetest.audio.audiotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.repo.MachineRepo;

@Service
public class MachineServiceImpl implements MachineService{
	
	@Autowired
	MachineRepo machineRepo;

	@Transactional()
	@Override
	public List<Machine> getAllMachine() {
		return machineRepo.findAll();
	}

}
