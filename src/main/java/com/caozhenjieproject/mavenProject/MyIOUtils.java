package com.caozhenjieproject.mavenProject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyIOUtils {

	private static final Logger logger = LoggerFactory.getLogger(MyIOUtils.class);
	
	public static String getFileContent(String filePath) throws IOException{
		byte[] bytes = Files.readAllBytes(Paths.get(filePath));
		return new String(bytes, StandardCharsets.UTF_8);
	}
	
	public static StringBuffer inputStreamToStringBuffer(InputStream inputStream)
			throws IOException {
		BufferedReader br = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			br = new BufferedReader(inputStreamReader);
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				if (sb.length() != 0) {
					sb.append(System.lineSeparator());
				}
				sb.append(line);
			}
			return sb;
		} catch (IOException e) {
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}
	
	public static String inputStreamToString(InputStream inputStream)
			throws IOException {
		return MyIOUtils.inputStreamToStringBuffer(inputStream).toString();
	}
	
	public static byte[] stringToUtf8Bytes(String str){
		try {
			return str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String readerToString(Reader reader){
		String result = null;
		try {
			result = IOUtils.toString(reader);
		} catch (IOException e) {
			throw new RuntimeException("Faid to read string from reader", e);
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
			}
		}
		return result;
		
	}
	
	public static void writeStringToFile(String content, String filePath)
			throws IOException {
		File file = new File(filePath);
		// if file doesn't exists, then create it
		if (!file.exists()) {
			if(!file.createNewFile()){
				throw new IOException("Can't create file " + filePath);
			}
		}
		FileOutputStream fop=null;
		try{
			fop = new FileOutputStream(file);
			// get the content in bytes
			byte[] contentInBytes = content.getBytes("UTF-8");
			fop.write(contentInBytes);
			fop.flush();
		}finally{
			if(fop != null){
				fop.close();
			}
		}
	}
	
	public static InputStream stringToInputStream(String str){
		
		if(str == null){
			return null;
		}
		
		return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		
	}
}
