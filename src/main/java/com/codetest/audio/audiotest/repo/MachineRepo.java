package com.codetest.audio.audiotest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetest.audio.audiotest.model.Machine;
import com.codetest.audio.audiotest.model.Reason;

@Repository
public interface MachineRepo extends JpaRepository<Machine, String>{

	List<Reason> findByMachine(String machine);

}
