package com.codetest.audio.audiotest.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.audio.audiotest.model.Action;
import com.codetest.audio.audiotest.repo.ActionRepo;

@Service
public class ActionServiceImpl implements ActionService{
	
	@Autowired
	ActionRepo actionRepo;

	@Transactional()
	@Override
	public List<Action> getAllAction() {
		return actionRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	

}
