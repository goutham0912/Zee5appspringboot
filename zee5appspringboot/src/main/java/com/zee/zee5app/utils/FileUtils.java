package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {
	public String addfile(String inputFilePath,String outputFilePath,long length) throws IOException
	{
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
	
			 fileOutputStream=new FileOutputStream(outputFilePath);
			 fileInputStream=new FileInputStream(inputFilePath);
			 byte[] data=new byte[(int) length];
			 fileInputStream.read(data);
			 fileOutputStream.write(data);
			 return "Success";
	
	}
	public byte[] readFile(File file) throws IOException
	{
		FileInputStream fileInputStream=new FileInputStream(file);
		 byte[] data=new byte[(int) file.length()];
		 fileInputStream.read(data);
		 return data;
		 

	}
	public String writeFile(byte[] data,String filename) throws IOException
	{
		try {
		FileOutputStream fileOutputStream=new FileOutputStream(filename);
		fileOutputStream.write(data);
		return "Success";
		}
		catch(Exception e)
		{
		return "fail";
		}
	}
}
