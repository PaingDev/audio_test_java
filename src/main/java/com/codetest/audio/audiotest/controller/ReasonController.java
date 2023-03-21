package com.codetest.audio.audiotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.audio.audiotest.model.Reason;
import com.codetest.audio.audiotest.service.ReasonService;

@RestController
@RequestMapping("/api/v1")
public class ReasonController {
	
	@Autowired
	ReasonService reasonService;
	
	@GetMapping("/reason")
	List<Reason> reasonByMachine(@RequestParam(required = false, value = "machine") String machine){
		List<Reason> listReason = reasonService.getReasonByMachine(machine);
		return listReason;
	}
}
