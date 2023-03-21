package com.codetest.audio.audiotest.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetest.audio.audiotest.model.Anomaly;
import com.codetest.audio.audiotest.model.Machine;

@Repository
public interface AnomalyRepo extends JpaRepository<Anomaly, Long>{

	List<Anomaly> findByMachine(Machine machine, Sort sort);

}
