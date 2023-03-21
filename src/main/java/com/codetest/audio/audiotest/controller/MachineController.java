package com.codetest.audio.audiotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.audio.audiotest.model.Action;
import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.service.ActionService;
import com.codetest.audio.audiotest.service.MachineService;

@RestController
@RequestMapping("/api/v1")
public class MachineController {
	@Autowired
	MachineService machineService;
	
	@GetMapping("/machine")
	List<Machine> allMachine(){
		List<Machine> listMachine = machineService.getAllMachine();
		return listMachine;
	}
	
}
