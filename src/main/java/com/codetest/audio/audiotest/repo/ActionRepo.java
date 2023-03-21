package com.codetest.audio.audiotest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetest.audio.audiotest.model.Action;

@Repository
public interface ActionRepo extends JpaRepository<Action, Long>{

}
