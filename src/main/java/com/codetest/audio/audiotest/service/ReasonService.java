package com.codetest.audio.audiotest.service;

import java.util.List;

import com.codetest.audio.audiotest.model.Reason;

public interface ReasonService {

	List<Reason> getReasonByMachine(String machine);

}
