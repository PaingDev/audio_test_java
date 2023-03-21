package com.codetest.audio.audiotest;

import java.util.Date;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.codetest.audio.audiotest.model.Action;
import com.codetest.audio.audiotest.model.Anomaly;
import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.model.Reason;
import com.codetest.audio.audiotest.repo.ActionRepo;
import com.codetest.audio.audiotest.repo.AnomalyRepo;
import com.codetest.audio.audiotest.repo.MachineRepo;
import com.codetest.audio.audiotest.repo.ReasonRepo;
import com.codetest.audio.audiotest.util.AudioUtil;

@Component
public class InsertDatabaseRunner implements CommandLineRunner{
	@Autowired
	AnomalyRepo anomalyRepo;
	
	@Autowired
	ActionRepo actionRepo;
	
	@Autowired
	ReasonRepo reasonRepo;
	
	@Autowired
	MachineRepo machinRepo;
	
	@Transactional(readOnly = false)
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
		
		AudioUtil audioUtil = AudioUtil.getInstance();
		
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		
		File theDir = new File(s+"/generated");
		if (!theDir.exists()){
		    theDir.mkdirs();
		    for(int i=1;i<7;i++) {
		    	
				audioUtil.generateAnomaly(new File(s+"/audio/"+i+".wav"), s+"/generated/"+i+".wav");
			}
		}else {
			for(int i=1;i<7;i++) {
				//checking generated file is exist or not
				File generatedFile = new File(s+"/generated/"+i+".wav");
				if(!generatedFile.exists()) {
					audioUtil.generateAnomaly(new File(s+"/audio/"+i+".wav"), s+"/generated/"+i+".wav");
				}
			}
		}
		
		if(machinRepo.findAll().isEmpty()) {
			List<Machine> listInitMachine = new ArrayList<>();
			listInitMachine.add(new Machine("CNC Machine"));
			listInitMachine.add(new Machine("Milling Machine"));
			machinRepo.saveAllAndFlush(listInitMachine);
		}
		
		
		
		
		

		if(actionRepo.findAll().isEmpty()) {
			List<Action> listInitAction = new ArrayList<>();
			listInitAction.add(new Action(null, "Immediate"));
			listInitAction.add(new Action(null, "Later"));
			listInitAction.add(new Action(null, "No Action"));
			
			//Action data store in db
			actionRepo.saveAllAndFlush(listInitAction);	
		}
		
		if(reasonRepo.findAll().isEmpty()) {
			List<Reason> listInitReason = new ArrayList<>();
			listInitReason.add(new Reason(null, new Machine("CNC Machine"),"Spindle Error"));
			listInitReason.add(new Reason(null, new Machine("CNC Machine"),"Axis Problem"));
			listInitReason.add(new Reason(null, new Machine("CNC Machine"),"Normal"));
			listInitReason.add(new Reason(null, new Machine("Milling Machine"),"Machine Crash"));
			listInitReason.add(new Reason(null, new Machine("Milling Machine"),"Router Fault"));
			listInitReason.add(new Reason(null, new Machine("Milling Machine"),"Normal"));
			
			reasonRepo.saveAllAndFlush(listInitReason);
		}
		
		if(anomalyRepo.findAll().isEmpty()) {
			List<Anomaly> listInitAnomaly = new ArrayList<>();
			// can also use Instant.ofEpochSecond(1628676001L);
			listInitAnomaly.add(new Anomaly(new Date(1628676001L*1000),new Machine("CNC Machine"),"Mild", "1234567890", "1.wav"));
			listInitAnomaly.add(new Anomaly(new Date(1629102961L*1000), new Machine("CNC Machine"),"Moderate", "0123456789", "2.wav"));
			listInitAnomaly.add(new Anomaly(new Date(1629058322L*1000), new Machine("CNC Machine"),"Severe", "1234567890", "3.wav"));
			listInitAnomaly.add(new Anomaly(new Date(1629057722L*1000),new Machine("Milling Machine"),"Mild", "1122334455", "4.wav"));
			listInitAnomaly.add(new Anomaly(new Date(1629025202L*1000),new Machine("Milling Machine"),"Moderate", "2345678900", "5.wav"));
			listInitAnomaly.add(new Anomaly(new Date(1629057361L*1000),new Machine("Milling Machine"),"Severe", "2345678900", "6.wav"));
			
			//Anomaly data store in db
			anomalyRepo.saveAllAndFlush(listInitAnomaly);
		}
	
	}

}
