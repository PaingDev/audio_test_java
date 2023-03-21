package com.codetest.audio.audiotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.audio.audiotest.model.Action;
import com.codetest.audio.audiotest.service.ActionService;

@RestController
@RequestMapping("/api/v1")
public class ActionController {
	@Autowired
	ActionService actionService;
	
	@GetMapping("/action")
	List<Action> allAction(){
		List<Action> listAction = actionService.getAllAction();
		return listAction;
	}
	
	
	
}
