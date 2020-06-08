/*
 *	Simple Wavefile Writer Class
 *	This file is combined from various source.
 * 	Modified by Bilge Mirac Atici to use only in educational purposes.
 *
 * 
 * 
 * WaveFileWriter(float[] array,long sampleRate, int bitSize,int channel, String name)
 * 			
 * 			
 * 			 		-> Constructor write a .wav file with given parametres.
 *					-> Be sure that your workspace directory is readable and writable!!!
 *					-> You can call converter methods directly (static method could be called with class name) 
 */

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class WaveFileWriter {

	public WaveFileWriter(float[] dataArray,float sampleRate, int bitSize,int channel, String name) throws IOException {
		
		byteData = new byte[dataArray.length*2];
			
		floatToByteArray(dataArray,byteData);

		long myByteRate = (long)sampleRate * channel * bitSize/8;
		int myBlockAlign = (int) (channel * bitSize/8);

		long myDataSize = byteData.length;
		long myChunkSize = 36 + (myDataSize * channel * bitSize/8);
			
		OutputStream os;
		os = new FileOutputStream(new File(name));
		BufferedOutputStream bos = new BufferedOutputStream(os);
		DataOutputStream outFile = new DataOutputStream(bos);
	
		//Writing the header of the wav file
		outFile.writeBytes("RIFF");                                 	// 00 - RIFF
		outFile.write(intToByteArray((int)myChunkSize), 0, 4);      	// 04 - how big is the rest of this file?
		outFile.writeBytes("WAVE");                                 	// 08 - WAVE
		outFile.writeBytes("fmt ");                                 	// 12 - fmt 
	  	outFile.write(intToByteArray((int)bitSize), 0, 4);  	// 16 - size of this chunk
	   	outFile.write(shortToByteArray((short)1), 0, 2);    		// 20 - what is the audio format? 1 for PCM = Pulse Code Modulation
	   	outFile.write(shortToByteArray((short)channel), 0, 2);   	// 22 - mono or stereo? 1 or 2?  (or 5 or ???)
	   	outFile.write(intToByteArray((int)sampleRate), 0, 4);     		// 24 - samples per second (numbers per second)
	   	outFile.write(intToByteArray((int)myByteRate), 0, 4);      		// 28 - bytes per second
	   	outFile.write(shortToByteArray((short)myBlockAlign), 0, 2);     // 32 - # of bytes in one sample, for all channels
	   	outFile.write(shortToByteArray((short)bitSize), 0, 2);  // 34 - how many bits in a sample(number)?  usually 16 or 24
	   	outFile.writeBytes("data");                                 	// 36 - data
	   	outFile.write(intToByteArray((int)myDataSize), 0, 4);     	    // 40 - how big is this data chunk
	   	outFile.write(byteData);                                   		    // 44 - the actual data itself - just a long string of numbers
	   	outFile.flush();
	   	outFile.close();
	}
		
	
	private static byte[] intToByteArray(int i) {
		byte[] b = new byte[4];
		b[0] = (byte) (i & 0x00FF);
		b[1] = (byte) ((i >> 8) & 0x000000FF);
		b[2] = (byte) ((i >> 16) & 0x000000FF);
		b[3] = (byte) ((i >> 24) & 0x000000FF);
		return b;
	}

	private static byte[] shortToByteArray(short data) {
		return new byte[]{(byte)(data & 0xff),(byte)((data >>> 8) & 0xff)};
	}	
	
	
	private static byte[] floatToByteArray(float[] in_buff, byte[] out_buff) {
        int ox = 0;
        int len = in_buff.length;
        for (int ix = 0; ix < len; ix++) {
            int x = (int) (in_buff[ix] * 32767.0);
            out_buff[ox++] = (byte) x;
            out_buff[ox++] = (byte) (x >>> 8);
        }
        return out_buff;
    }
	
	private  byte[] byteData;

}	
