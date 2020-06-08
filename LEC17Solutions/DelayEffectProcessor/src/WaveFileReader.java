/*
 *	SimpleAudioPlayer.java
 *	This file modified version of a file from jsresources.org
 * Copyright (c) 1999 - 2001 by Matthias Pfisterer
 * [Modified by Baris Bozkurt to use only in educational purposes]
 */


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WaveFileReader  {

	public WaveFileReader(String	strFilename)
	{
		File soundFile = new File(strFilename);

		AudioInputStream audioInputStream = null;
		try{
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		}
		catch (Exception e){
			e.printStackTrace();System.exit(1);
		}

		audioFormat = audioInputStream.getFormat();

		int	nBytesRead = 0;
		abData = new byte[(int)audioInputStream.getFrameLength()*2];
		while (nBytesRead != -1)
		{
			try{
				nBytesRead = audioInputStream.read(abData, 0, abData.length);

			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		//conversion from bytes to integers

		int nlengthInSamples = abData.length / 2;
		audioData = new int[nlengthInSamples];
		if (audioFormat.isBigEndian()) {
			for (int i = 0; i < nlengthInSamples; i++) {
				/* First byte is MSB (high order) */
				int MSB = (int) abData[2*i];
				/* Second byte is LSB (low order) */
				int LSB = (int) abData[2*i+1];
				audioData[i] = MSB << 8 | (255 & LSB);
			}
		} else {
			for (int i = 0; i < nlengthInSamples; i++) {
				/* First byte is LSB (low order) */
				int LSB = (int) abData[2*i];
				/* Second byte is MSB (high order) */
				int MSB = (int) abData[2*i+1];
				audioData[i] = MSB << 8 | (255 & LSB);
			}
		}
		floatData = new float[abData.length/2];
		tofloatArray(abData,floatData);
		
	}
	public float[] getFloatArray(){
		return floatData;
	}
	public float getSamplingFreq(){
		return audioFormat.getSampleRate();
	}
	public int getBitRate(){
		return audioFormat.getSampleSizeInBits();
	}
	private float[] tofloatArray(byte[] in_buff, float[] out_buff) {
        int ix =0;
        int len = (in_buff.length/2);
        for (int ox = 0; ox < len; ox++) {
            out_buff[ox] = ((short) ((in_buff[ix++] & 0xFF) | 
                       (in_buff[ix++] << 8))) * (1.0f / 32767.0f);
        }
        return out_buff;
    }
	private AudioFormat audioFormat;
	private int[] audioData;
	private byte[] abData;
	private float[] floatData;
}



