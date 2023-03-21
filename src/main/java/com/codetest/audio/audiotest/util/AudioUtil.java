package com.codetest.audio.audiotest.util;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.io.jvm.WaveformWriter;

public class AudioUtil {
	
	private static AudioUtil instance = null;
	
	private AudioProcessor anomalyProcessor = null;
	
	private AudioUtil() {
		// Create an audio processor to add an anomaly
		anomalyProcessor = new AudioProcessor() {
			@Override
			public boolean process(AudioEvent audioEvent) {
				// Get the audio buffer
				float[] audioBuffer = audioEvent.getFloatBuffer();

				// Add an anomaly to the audio buffer
				for (int i = 0; i < audioBuffer.length; i++) {
					if (i % 1000 == 0) {
						audioBuffer[i] = (float) (audioBuffer[i] * 2.0);
					}
				}
				return true;
			}

			@Override
			public void processingFinished() {
				// Do nothing
			}
		};	
	}
	
	public static AudioUtil getInstance(){
		if(instance == null) {
			instance = new AudioUtil();
		}	
		return instance;
	}
	
	public void generateAnomaly(String inputFilePath, String outputFilePath) {
		try {
			// Load the input audio file
			AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(new File(inputFilePath), 1024, 0);
			
			// Add the anomaly processor to the dispatcher
			dispatcher.addAudioProcessor(anomalyProcessor);
			// Write the output waveform to a file
			WaveformWriter waveformWriter = new WaveformWriter(dispatcher.getFormat(), outputFilePath);
			dispatcher.addAudioProcessor(waveformWriter);

			// Start the dispatcher
			dispatcher.run();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateAnomaly(File file, String outputFilePath) {
		try {
			// Load the input audio file
			AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(file, 1024, 0);
			
			// Add the anomaly processor to the dispatcher
			dispatcher.addAudioProcessor(anomalyProcessor);
			// Write the output waveform to a file
			WaveformWriter waveformWriter = new WaveformWriter(dispatcher.getFormat(), outputFilePath);
			dispatcher.addAudioProcessor(waveformWriter);

			// Start the dispatcher
			dispatcher.run();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
