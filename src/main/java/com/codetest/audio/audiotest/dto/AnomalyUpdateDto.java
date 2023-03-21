package com.codetest.audio.audiotest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnomalyUpdateDto {
	Long id;
	Long reasonId;
	Long actionId;
	String comment;
	

}
